package com.example.model

import androidx.compose.ui.graphics.Color

enum class TradeIcon {
    CODING,
    GRAPHIC_DESIGN,
    AUTO_MECHANICS,
    TAILORING,
    ELECTRICAL,
    BARBER_BEAUTY
}

data class LessonSection(
    val heading: String,
    val body: String,
    val practicalTip: String? = null
)

data class LessonModule(
    val id: String,
    val moduleNumber: Int,
    val title: String,
    val durationMinutes: Int,
    val summary: String,
    val sections: List<LessonSection>
)

data class TradeCourse(
    val id: String,
    val title: String,
    val subtitle: String,
    val category: String,
    val description: String,
    val icon: TradeIcon,
    val accentColor: Color,
    val pdfGuideTitle: String,
    val modules: List<LessonModule>
)

data class Workshop(
    val id: String,
    val tradeTitle: String,
    val title: String,
    val instructorName: String,
    val instructorCredential: String,
    val location: String,
    val duration: String,
    val priceHtg: Int,
    val nextCohort: String,
    val spotsLeft: Int,
    val includedItems: List<String>,
    val whatsappPhone: String,
    val whatsappPrefillMessage: String
)
