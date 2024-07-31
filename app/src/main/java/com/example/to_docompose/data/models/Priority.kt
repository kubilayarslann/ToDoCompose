package com.example.to_docompose.data.models

import androidx.compose.ui.graphics.Color
import com.example.to_docompose.ui.theme.HighPriorItyColor
import com.example.to_docompose.ui.theme.LowPriorItyColor
import com.example.to_docompose.ui.theme.MediumPriorItyColor
import com.example.to_docompose.ui.theme.NonePriorItyColor

enum class Priority(val color: Color) {
    HIGH(HighPriorItyColor),
    MEDIUM(MediumPriorItyColor),
    LOW(LowPriorItyColor),
    NONE(NonePriorItyColor)
}