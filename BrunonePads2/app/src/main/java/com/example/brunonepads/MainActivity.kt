package com.example.brunonepads

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
            Grid(notasList = notasViewModel.notasList, playbackViewModel = notasViewModel)
        }
    }
}
