package com.example.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarRepair
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.ContentCut
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.Palette
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.model.TradeIcon

fun TradeIcon.toImageVector(): ImageVector = when (this) {
    TradeIcon.CODING -> Icons.Filled.Code
    TradeIcon.GRAPHIC_DESIGN -> Icons.Filled.Palette
    TradeIcon.AUTO_MECHANICS -> Icons.Filled.CarRepair
    TradeIcon.TAILORING -> Icons.Filled.Checkroom
    TradeIcon.ELECTRICAL -> Icons.Filled.ElectricBolt
    TradeIcon.BARBER_BEAUTY -> Icons.Filled.ContentCut
}
