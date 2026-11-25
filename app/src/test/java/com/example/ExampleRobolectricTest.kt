package com.example

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.TradeRepository
import com.example.viewmodel.AprannMetyeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.withTimeout
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `read app name from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Aprann Metye", appName)
    }

    @Test
    fun `repository contains 6 trades and 6 workshops`() {
        assertEquals(6, TradeRepository.trades.size)
        assertEquals(6, TradeRepository.workshops.size)
        assertTrue(TradeRepository.trades.all { it.modules.isNotEmpty() })
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `viewmodel search filters trades dynamically`() = runBlocking {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        try {
            val app = ApplicationProvider.getApplicationContext<Application>()
            val viewModel = AprannMetyeViewModel(app)
            viewModel.onSearchQueryChange("Mekanik")
            val state = withTimeout(5_000L) {
                viewModel.uiState.first { it.searchQuery == "Mekanik" }
            }
            assertEquals(1, state.filteredTrades.size)
            assertEquals("Mekanik Oto", state.filteredTrades.first().title)
        } finally {
            Dispatchers.resetMain()
        }
    }
}
