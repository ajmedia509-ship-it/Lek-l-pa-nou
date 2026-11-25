package com.example.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.WorkspacePremium
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.R
import com.example.ui.screens.CourseDetailScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.WorkshopsScreen
import com.example.ui.theme.AmberVibrant
import com.example.ui.theme.NavyDeep
import com.example.viewmodel.AprannMetyeViewModel
import kotlinx.coroutines.launch

private data class BottomTabItem(
    val route: String,
    val labelRes: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val testTag: String
)

private val bottomTabs = listOf(
    BottomTabItem(
        route = AppRoutes.ROUTE_HOME,
        labelRes = R.string.tab_free_courses,
        selectedIcon = Icons.Filled.School,
        unselectedIcon = Icons.Outlined.School,
        testTag = "nav_tab_free_courses"
    ),
    BottomTabItem(
        route = AppRoutes.ROUTE_WORKSHOPS,
        labelRes = R.string.tab_workshops,
        selectedIcon = Icons.Filled.WorkspacePremium,
        unselectedIcon = Icons.Outlined.WorkspacePremium,
        testTag = "nav_tab_workshops"
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AprannMetyeApp(
    viewModel: AprannMetyeViewModel = viewModel()
) {
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route

    val showTopLevelChrome = currentRoute == AppRoutes.ROUTE_HOME ||
        currentRoute == AppRoutes.ROUTE_WORKSHOPS

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    fun showMessage(message: String) {
        coroutineScope.launch {
            snackbarHostState.currentSnackbarData?.dismiss()
            snackbarHostState.showSnackbar(message)
        }
    }

    fun navigateToTab(route: String) {
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val useNavigationRail = maxWidth >= 700.dp

        Row(modifier = Modifier.fillMaxSize()) {
            if (showTopLevelChrome && useNavigationRail) {
                NavigationRail(
                    containerColor = MaterialTheme.colorScheme.surface,
                    modifier = Modifier.navigationBarsPadding()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    bottomTabs.forEach { tab ->
                        val selected = currentDestination?.hierarchy?.any {
                            it.route == tab.route
                        } == true
                        NavigationRailItem(
                            selected = selected,
                            onClick = { navigateToTab(tab.route) },
                            icon = {
                                Icon(
                                    imageVector = if (selected) tab.selectedIcon else tab.unselectedIcon,
                                    contentDescription = stringResource(tab.labelRes)
                                )
                            },
                            label = { Text(stringResource(tab.labelRes)) },
                            modifier = Modifier.testTag(tab.testTag),
                            colors = NavigationRailItemDefaults.colors(
                                selectedIconColor = NavyDeep,
                                selectedTextColor = MaterialTheme.colorScheme.onSurface,
                                indicatorColor = AmberVibrant,
                                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            Scaffold(
                modifier = Modifier.weight(1f),
                contentWindowInsets = WindowInsets.statusBars,
                snackbarHost = {
                    if (showTopLevelChrome) {
                        SnackbarHost(hostState = snackbarHostState)
                    }
                },
                topBar = {
                    if (showTopLevelChrome) {
                        val isHome = currentRoute == AppRoutes.ROUTE_HOME
                        TopAppBar(
                            title = {
                                Column {
                                    Text(
                                        text = if (isHome) {
                                            stringResource(R.string.app_name)
                                        } else {
                                            stringResource(R.string.workshops_title)
                                        },
                                        style = MaterialTheme.typography.headlineSmall
                                    )
                                    Text(
                                        text = if (isHome) {
                                            stringResource(R.string.home_subtitle)
                                        } else {
                                            stringResource(R.string.workshops_subtitle)
                                        },
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                titleContentColor = MaterialTheme.colorScheme.onBackground
                            )
                        )
                    }
                },
                bottomBar = {
                    if (showTopLevelChrome && !useNavigationRail) {
                        NavigationBar(
                            containerColor = MaterialTheme.colorScheme.surface,
                            tonalElevation = 4.dp
                        ) {
                            bottomTabs.forEach { tab ->
                                val selected = currentDestination?.hierarchy?.any {
                                    it.route == tab.route
                                } == true
                                NavigationBarItem(
                                    selected = selected,
                                    onClick = { navigateToTab(tab.route) },
                                    icon = {
                                        Icon(
                                            imageVector = if (selected) tab.selectedIcon else tab.unselectedIcon,
                                            contentDescription = stringResource(tab.labelRes),
                                            modifier = Modifier.size(24.dp)
                                        )
                                    },
                                    label = {
                                        Text(
                                            text = stringResource(tab.labelRes),
                                            style = MaterialTheme.typography.labelMedium
                                        )
                                    },
                                    modifier = Modifier.testTag(tab.testTag),
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = NavyDeep,
                                        selectedTextColor = MaterialTheme.colorScheme.onSurface,
                                        indicatorColor = AmberVibrant,
                                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                )
                            }
                        }
                    }
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = AppRoutes.ROUTE_HOME,
                        enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(250)
                            )
                        },
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(250)
                            )
                        },
                        popEnterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                animationSpec = tween(250)
                            )
                        },
                        popExitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                animationSpec = tween(250)
                            )
                        }
                    ) {
                        composable(route = AppRoutes.ROUTE_HOME) {
                            HomeScreen(
                                uiState = uiState,
                                onSearchQueryChange = viewModel::onSearchQueryChange,
                                onCategorySelected = viewModel::onCategorySelected,
                                onClearFilters = viewModel::clearFilters,
                                onTradeClick = { trade ->
                                    navController.navigate(AppRoutes.courseDetailRoute(trade.id))
                                }
                            )
                        }

                        composable(route = AppRoutes.ROUTE_WORKSHOPS) {
                            WorkshopsScreen(
                                workshops = uiState.workshops,
                                onShowMessage = ::showMessage
                            )
                        }

                        composable(
                            route = AppRoutes.ROUTE_COURSE_DETAIL,
                            arguments = listOf(
                                navArgument(AppRoutes.ARG_TRADE_ID) {
                                    type = NavType.StringType
                                }
                            )
                        ) { backStackEntry ->
                            val tradeId = backStackEntry.arguments?.getString(AppRoutes.ARG_TRADE_ID)
                            val trade = tradeId?.let { viewModel.getTradeById(it) }
                            if (trade != null) {
                                CourseDetailScreen(
                                    trade = trade,
                                    completedModuleIds = uiState.completedModuleIds,
                                    isGuideDownloaded = uiState.downloadedGuideTradeIds.contains(trade.id),
                                    isDownloadingPdf = uiState.isDownloadingPdf,
                                    snackbarHostState = snackbarHostState,
                                    onBackClick = { navController.popBackStack() },
                                    onToggleModuleCompleted = viewModel::toggleModuleCompleted,
                                    onDownloadPdfClick = { selectedTrade ->
                                        viewModel.downloadPdfGuide(context, selectedTrade) { _, message ->
                                            showMessage(message)
                                        }
                                    }
                                )
                            } else {
                                // Fallback gracefully if an invalid route is passed
                                HomeScreen(
                                    uiState = uiState,
                                    onSearchQueryChange = viewModel::onSearchQueryChange,
                                    onCategorySelected = viewModel::onCategorySelected,
                                    onClearFilters = viewModel::clearFilters,
                                    onTradeClick = { selected ->
                                        navController.navigate(AppRoutes.courseDetailRoute(selected.id))
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
