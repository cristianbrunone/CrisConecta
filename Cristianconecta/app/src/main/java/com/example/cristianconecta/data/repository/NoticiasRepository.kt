package com.example.cristianconecta.data.repository

import com.example.cristianconecta.data.model.DataSource
import com.example.cristianconecta.data.model.Informacion
import com.example.cristianconecta.data.model.Noticia

class NoticiasRepository {

    companion object {
        fun obtenerNoticias(): List<Noticia> {
            return DataSource.noticias
        }

        fun obtenerInformaciones(): List<Informacion> {
            return DataSource.informaciones
        }
    }
}