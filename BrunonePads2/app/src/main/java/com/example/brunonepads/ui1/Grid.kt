package com.example.brunonepads.ui1

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.brunonepads.model.NotasItemModel
import com.example.brunonepads.viewmodel.NotasViewModel

@Composable
fun Grid(notasList: List<NotasItemModel>, playbackViewModel: NotasViewModel) {
    LazyVerticalGrid(columns = GridCells.Fixed(4),
        modifier = Modifier.padding(16.dp)
    ){
        items(notasList) { nota ->
            CardItem(nota = nota, playbackViewModel = playbackViewModel)
        }
    }
}


