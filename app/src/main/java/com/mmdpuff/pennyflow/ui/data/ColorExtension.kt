package com.mmdpuff.pennyflow.ui.data

import androidx.compose.ui.graphics.Color

val Int.color: Color
    get() = Color(0xFF000000.toInt() or this)