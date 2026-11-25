package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.progressDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "aprann_metye_progress"
)

class ProgressRepository(private val context: Context) {

    private object Keys {
        val COMPLETED_MODULES = stringSetPreferencesKey("completed_module_ids")
        val DOWNLOADED_GUIDES = stringSetPreferencesKey("downloaded_guide_trade_ids")
    }

    val completedModuleIds: Flow<Set<String>> = context.progressDataStore.data.map { prefs ->
        prefs[Keys.COMPLETED_MODULES] ?: emptySet()
    }

    val downloadedGuideTradeIds: Flow<Set<String>> = context.progressDataStore.data.map { prefs ->
        prefs[Keys.DOWNLOADED_GUIDES] ?: emptySet()
    }

    suspend fun toggleModuleCompleted(moduleId: String) {
        context.progressDataStore.edit { prefs ->
            val current = prefs[Keys.COMPLETED_MODULES]?.toMutableSet() ?: mutableSetOf()
            if (current.contains(moduleId)) {
                current.remove(moduleId)
            } else {
                current.add(moduleId)
            }
            prefs[Keys.COMPLETED_MODULES] = current
        }
    }

    suspend fun markGuideDownloaded(tradeId: String) {
        context.progressDataStore.edit { prefs ->
            val current = prefs[Keys.DOWNLOADED_GUIDES]?.toMutableSet() ?: mutableSetOf()
            current.add(tradeId)
            prefs[Keys.DOWNLOADED_GUIDES] = current
        }
    }
}
