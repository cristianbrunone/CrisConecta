package com.example.brunonepads

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.example.brunonepads.ui1.Grid
import com.example.brunonepads.viewmodel.NotasViewModel

class MainActivity : ComponentActivity() {

    private val notasViewModel: NotasViewModel by lazy {
        ViewModelProvider(this).get(NotasViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Observa los cambios en las notas y actualiza la interfaz de usuario
            val playbackState = notasViewModel.getPlaybackState()

            // Cambiar el fondo de toda la actividad
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(if (playbackState.isPlaying) Color.Green else Color.DarkGray)
            ) {
                // Observa los cambios en las notas y actualiza la interfaz de usuario
                Grid(notasList = notasViewModel.notasList, playbackViewModel = notasViewModel)
            }
        }
    }
}
