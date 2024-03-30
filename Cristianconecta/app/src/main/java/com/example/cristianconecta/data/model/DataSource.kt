package com.example.cristianconecta.data.model

import com.example.nuevaaplicacion.R

object DataSource {

    val informaciones = listOf(
        Informacion(
            id = 1,
            titulo = "Vaga interna",
            contenido = "Contenido de la noticia 1",
            iconoUrl = R.drawable.noticia1
        ),
        Informacion(
            id = 2,
            titulo = "Cardápio de hoje",
            contenido = "Contenido de la noticia 2",
            iconoUrl = R.drawable.noticia2
        ),
        Informacion(
            id = 3,
            titulo = "Grupo de melhorias",
            contenido = "Contenido de la noticia 3",
            iconoUrl = R.drawable.noticia3
        )
    )

    val noticias = listOf(
        Noticia(
            id = 1,
            titulo = "Vaga interna",
            contenido = "Contenido de la noticia 1",
            fechaPublicacion = "18-02-2024",
            imagenUrl = R.drawable.noticia1
        ),
        Noticia(
            id = 2,
            titulo = "Cardápio de hoje",
            contenido = "Contenido de la noticia 2",
            fechaPublicacion = "18-02-2024",
            imagenUrl = R.drawable.noticia2
        ),
        Noticia(
            id = 3,
            titulo = "Grupo de melhorias",
            contenido = "Contenido de la noticia 3",
            fechaPublicacion = "18-02-2024",
            imagenUrl = R.drawable.noticia3
        ),
        Noticia(
            id = 4,
            titulo = "Torneio de Futsal",
            contenido = "Contenido de la noticia 4",
            fechaPublicacion = "18-02-2024",
            imagenUrl = R.drawable.noticia4
        ),
        Noticia(
            id = 5,
            titulo = "Nueva noticia",
            contenido = "Contenido de la noticia 5",
            fechaPublicacion = "18-02-2024",
            imagenUrl = R.drawable.noticia5
        ),
        Noticia(
            id = 6,
            titulo = "Auditoria Externa",
            contenido = "Contenido de la noticia 6",
            fechaPublicacion = "18-02-2024",
            imagenUrl = R.drawable.noticia6
        ),
        Noticia(
            id = 7,
            titulo = "Resultados PLR",
            contenido = "Contenido de la noticia 7",
            fechaPublicacion = "18-02-2024",
            imagenUrl = R.drawable.noticias7
        )
    )
}

