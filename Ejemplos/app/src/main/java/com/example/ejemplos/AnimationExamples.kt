package com.example.ejemplos

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorAnimationSimple() {
    Column {
        var firstcolor by remember {
            mutableStateOf(false)
        }
        var realColor = if (firstcolor) Color.Red else Color.Yellow
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { firstcolor = !firstcolor }
        )

        Spacer(modifier = Modifier.size(200.dp))

        var secondcolor by remember {
            mutableStateOf(false)
        }
        val realColor2 by animateColorAsState(targetValue = if (secondcolor) Color.Red else Color.Yellow)
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor2)
                .clickable { secondcolor = !secondcolor }
        )

        Spacer(modifier = Modifier.size(200.dp))
    }
}
