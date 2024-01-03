package com.example.brunonepads.repository

import com.example.brunonepads.R
import com.example.brunonepads.model.SuperNota
/*Crear Repositorio (paso 2)*/
class SuperNotaRepository {
    private val _superNotas = mutableListOf<SuperNota>()

    // Función para obtener las SuperNotas
    fun getSuperNotas(): List<SuperNota> {
        if (_superNotas.isEmpty()) {
            cargarSuperNotasEnRepositorio()
        }
        // Devolvemos la lista
        return _superNotas
    }

    // Función para cargar las SuperNotas en el repositorio
    private fun cargarSuperNotasEnRepositorio() {
        _superNotas.addAll(
            listOf(
                SuperNota("Nota_C", R.drawable.nota_c, "notas_C" ),
                SuperNota("Nota_C#", R.drawable.nota_c_sostenido, "notas_C#"),
                SuperNota("Nota_D", R.drawable.nota_d, "notas_D"),
                SuperNota("Nota_D#", R.drawable.nota_d_sostenido, "notas_D#"),
                SuperNota("Nota_E", R.drawable.nota_e, "notas_E"),
                SuperNota("Nota_F", R.drawable.nota_f, "notas_F"),
                SuperNota("Nota_F#", R.drawable.nota_f_sostenido, "notas_F#"),
                SuperNota("Nota_G", R.drawable.nota_g,"notas_G"),
                SuperNota("Nota_G#", R.drawable.nota_g_sostenido, "notas_G#"),
                SuperNota("Nota_A", R.drawable.nota_a, "notas_A"),
                SuperNota("Nota_A#", R.drawable.nota_a_sostenido,"notas_A#"),
                SuperNota("Nota_B", R.drawable.nota_b,"notas_B")
            )
        )
    }
}
