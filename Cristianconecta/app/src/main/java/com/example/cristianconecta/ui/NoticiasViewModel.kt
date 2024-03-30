package com.example.cristianconecta.ui

import androidx.lifecycle.ViewModel
import com.example.cristianconecta.data.model.Noticia
import com.example.cristianconecta.data.repository.NoticiasRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NoticiasViewModel : ViewModel() {
    // StateFlow para almacenar la lista de noticias
    private val _noticias = MutableStateFlow<List<Noticia>>(emptyList())
    val noticias: StateFlow<List<Noticia>> = _noticias

    // StateFlow para indicar si se debe mostrar la pantalla de detalles
    private val _mostrarDetalleNoticia = MutableStateFlow(false)
    val mostrarDetalleNoticia: StateFlow<Boolean> = _mostrarDetalleNoticia

    // Noticia seleccionada actualmente
    private var noticiaSeleccionada: Noticia? = null

    // Función para cargar las noticias desde el repositorio
    fun cargarNoticias() {
        val listaDeNoticias = NoticiasRepository.obtenerNoticias()
        _noticias.value = listaDeNoticias
    }

    // Función para manejar cuando se hace clic en una noticia
    fun onNoticiaClicked(noticia: Noticia) {
        noticiaSeleccionada = noticia
        _mostrarDetalleNoticia.value = true
    }

    // Función para manejar la navegación desde la pantalla de detalles de la noticia
    fun onDetalleNoticiaNavigated(){
        _mostrarDetalleNoticia.value = false
    }


}
