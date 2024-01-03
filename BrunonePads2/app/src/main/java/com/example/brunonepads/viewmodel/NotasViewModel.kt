package com.example.brunonepads.viewmodel

import NotasRepository
import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import com.example.brunonepads.model.NotasItemModel

class NotasViewModel(application: Application) : AndroidViewModel(application) {

    private val notasRepository = NotasRepository()
    private var mediaPlayer: MediaPlayer? = null

    // Lista de notas
    val notasList: List<NotasItemModel> by lazy {
        notasRepository.obtenerNotas()
    }

    // Estado de reproducción actual
    private var playbackState: PlaybackState = PlaybackState()

    // Función para cambiar el estado de reproducción al tocar una nota
    fun togglePlayback(item: NotasItemModel) {
        if (playbackState.itemId == item.id) {
            // Si ya se está reproduciendo la nota, detener la reproducción
            stopPlayback()
        } else {
            // Si no, iniciar la reproducción de la nueva nota
            startPlayback(item)
        }
    }

    // Función para iniciar la reproducción de una nota
    private fun startPlayback(item: NotasItemModel) {
        stopPlayback() // Detener la reproducción anterior, si la hay
        mediaPlayer = MediaPlayer.create(getApplication(), item.rutaSonido)
        mediaPlayer?.start()
        playbackState = PlaybackState(true, item.id)
    }

    // Función para detener la reproducción
    private fun stopPlayback() {
        mediaPlayer?.release()
        mediaPlayer = null
        playbackState = PlaybackState()
    }

    // Función para obtener el estado de reproducción actual
    fun getPlaybackState(): PlaybackState {
        return playbackState
    }

    data class PlaybackState(
        val isPlaying: Boolean = false,
        val itemId: Int? = null
    )
}
