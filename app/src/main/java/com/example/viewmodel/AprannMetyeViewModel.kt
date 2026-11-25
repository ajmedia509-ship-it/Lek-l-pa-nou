package com.example.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.PdfGuideExporter
import com.example.data.ProgressRepository
import com.example.data.TradeRepository
import com.example.model.TradeCourse
import com.example.model.Workshop
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class AprannMetyeUiState(
    val searchQuery: String = "",
    val selectedCategory: String = "Tout",
    val categories: List<String> = TradeRepository.categories,
    val allTrades: List<TradeCourse> = TradeRepository.trades,
    val filteredTrades: List<TradeCourse> = TradeRepository.trades,
    val workshops: List<Workshop> = TradeRepository.workshops,
    val completedModuleIds: Set<String> = emptySet(),
    val downloadedGuideTradeIds: Set<String> = emptySet(),
    val isDownloadingPdf: Boolean = false
) {
    val totalModuleCount: Int
        get() = allTrades.sumOf { it.modules.size }

    val completedCount: Int
        get() = completedModuleIds.size
}

class AprannMetyeViewModel(application: Application) : AndroidViewModel(application) {

    private val progressRepository = ProgressRepository(application.applicationContext)

    private val searchQueryFlow = MutableStateFlow("")
    private val selectedCategoryFlow = MutableStateFlow("Tout")
    private val isDownloadingPdfFlow = MutableStateFlow(false)

    val uiState: StateFlow<AprannMetyeUiState> = combine(
        searchQueryFlow,
        selectedCategoryFlow,
        progressRepository.completedModuleIds,
        progressRepository.downloadedGuideTradeIds,
        isDownloadingPdfFlow
    ) { query, category, completedModules, downloadedGuides, isDownloadingPdf ->
        val filtered = filterTrades(
            trades = TradeRepository.trades,
            query = query,
            category = category
        )
        AprannMetyeUiState(
            searchQuery = query,
            selectedCategory = category,
            categories = TradeRepository.categories,
            allTrades = TradeRepository.trades,
            filteredTrades = filtered,
            workshops = TradeRepository.workshops,
            completedModuleIds = completedModules,
            downloadedGuideTradeIds = downloadedGuides,
            isDownloadingPdf = isDownloadingPdf
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = AprannMetyeUiState()
    )

    fun onSearchQueryChange(newQuery: String) {
        searchQueryFlow.value = newQuery
    }

    fun onCategorySelected(category: String) {
        selectedCategoryFlow.value = category
    }

    fun clearFilters() {
        searchQueryFlow.value = ""
        selectedCategoryFlow.value = "Tout"
    }

    fun getTradeById(tradeId: String): TradeCourse? {
        return TradeRepository.trades.find { it.id == tradeId }
    }

    fun toggleModuleCompleted(moduleId: String) {
        viewModelScope.launch {
            progressRepository.toggleModuleCompleted(moduleId)
        }
    }

    fun downloadPdfGuide(
        context: Context,
        trade: TradeCourse,
        onComplete: (Boolean, String) -> Unit
    ) {
        if (isDownloadingPdfFlow.value) return
        viewModelScope.launch {
            isDownloadingPdfFlow.value = true
            val result = PdfGuideExporter.generateTradeGuidePdf(context, trade)
            isDownloadingPdfFlow.value = false
            result.onSuccess {
                progressRepository.markGuideDownloaded(trade.id)
                onComplete(
                    true,
                    "Gid PDF \"${trade.pdfGuideTitle}\" telechaje avèk siksè!"
                )
            }.onFailure {
                onComplete(
                    false,
                    "Gen yon erè ki rive pandan telechajman gid PDF la."
                )
            }
        }
    }

    private fun filterTrades(
        trades: List<TradeCourse>,
        query: String,
        category: String
    ): List<TradeCourse> {
        val normalizedQuery = query.trim().lowercase()
        return trades.filter { trade ->
            val matchesCategory = category == "Tout" || trade.category.equals(category, ignoreCase = true)
            val matchesQuery = normalizedQuery.isEmpty() ||
                trade.title.lowercase().contains(normalizedQuery) ||
                trade.subtitle.lowercase().contains(normalizedQuery) ||
                trade.category.lowercase().contains(normalizedQuery) ||
                trade.description.lowercase().contains(normalizedQuery) ||
                trade.modules.any { it.title.lowercase().contains(normalizedQuery) }
            matchesCategory && matchesQuery
        }
    }
}
