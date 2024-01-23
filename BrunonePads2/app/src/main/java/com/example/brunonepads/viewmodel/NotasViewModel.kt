package com.example.brunonepads.viewmodel

import NotasRepository
import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import com.example.brunonepads.model.NotasItemModel
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class NotasViewModel(application: Application) : AndroidViewModel(application) {

    private val notasRepository = NotasRepository()
    private var mediaPlayer: MediaPlayer? = null
    private var selectedSoundNota: NotasItemModel? = null
    private var selectedImageNota: NotasItemModel? = null
    private var isUpdatingImage: Boolean = false // Variable de control
    private val _selectedImage: MutableState<NotasItemModel?> = mutableStateOf(null)
    private val selectedImagesMap = mutableMapOf<Int, NotasItemModel>()
    val selectedImage: MutableState<NotasItemModel?> = _selectedImage


    // Lista de notas
    val notasList: List<NotasItemModel> by lazy {
        notasRepository.obtenerNotas()
    }

    // Estado de reproducción actual
    private var playbackState: PlaybackState = PlaybackState()

    // Nota actualmente en reproducción
    private var currentlyPlayingNota: NotasItemModel? = null

    // Nota actualmente seleccionada
    private var selectedNota: NotasItemModel? = null

    // Función para cambiar el estado de reproducción al tocar una nota
    fun togglePlayback(item: NotasItemModel, isCardClicked: Boolean = false) {
        if (isPlaying() && currentlyPlayingNota?.id == item.id) {
            stopPlayback()
        } else {
            startPlayback(item)
            selectedNota = if (isCardClicked) item else null
        }
    }


    // Función para cambiar el estado de reproducción al tocar una imagen
    fun toggleImageSelection(item: NotasItemModel) {
        if (!isUpdatingImage) {
            isUpdatingImage = true

            if (_selectedImage.value?.id == item.id) {
                _selectedImage.value = null
                stopPlayback()
            } else {
                _selectedImage.value = item
                // Detener la reproducción anterior, si la hay

                stopPlayback()

                // Iniciar la reproducción de la nueva nota
                startPlayback(item)
            }

            isUpdatingImage = false
        }
    }

    fun getSelectedImage(item: NotasItemModel): NotasItemModel? {
        return if (item.id == selectedImageNota?.id) null else item
    }

    fun getSelectedImageNota(): NotasItemModel? {
        return selectedImageNota
    }

    // Función para iniciar la reproducción de una nota
    private fun startPlayback(item: NotasItemModel) {
        stopPlayback() // Detener la reproducción anterior, si la hay
        mediaPlayer = MediaPlayer.create(getApplication(), item.rutaSonido).apply {
            start()
            playbackState = PlaybackState(true, item.id)
            currentlyPlayingNota = item
            setOnCompletionListener { stopPlayback() }
        }
    }

    // Función para detener la reproducción
    fun stopPlayback() {
        mediaPlayer?.release()
        mediaPlayer = null
        playbackState = PlaybackState()
        currentlyPlayingNota = null
    }

    // Función para obtener el estado de reproducción actual
    fun getPlaybackState(): PlaybackState {
        return playbackState
    }

    // Función para obtener la nota actualmente en reproducción
    fun getCurrentlyPlayingNota(): NotasItemModel? {
        return currentlyPlayingNota
    }

    // Función para verificar si se está reproduciendo alguna nota
    fun isPlaying(): Boolean {
        return playbackState.isPlaying
    }

    // Función para obtener el ID de la nota que se está reproduciendo
    fun getPlayingItemId(): Int? {
        return playbackState.itemId
    }

    // Función para obtener la nota actualmente seleccionada
    fun getSelectedNota(): NotasItemModel? {
        return selectedNota
    }

    data class PlaybackState(
        val isPlaying: Boolean = false,
        val itemId: Int? = null
    )
}
