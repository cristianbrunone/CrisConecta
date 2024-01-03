// VisualPads.kt

package com.example.brunonepads

import VisualPadsViewModel
import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.brunonepads.model.SuperNota
import com.example.brunonepads.viewmodel.VisualPadsViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.observeAsState

@Composable
fun VisualPads(viewModel: VisualPadsViewModel = viewModel()) {
    SuperNotasGridView(viewModel)
}

@Composable
fun SuperNotasGridView(viewModel: VisualPadsViewModel) {
    val superNotas by viewModel.superNotas.observeAsState(emptyList())

    LazyVerticalGrid(columns = GridCells.Adaptive(180.dp), content = {
        items(superNotas) { supernota ->
            ItemNota(supernotas = supernota, onItemSelected = {
                viewModel.onNotaClick(supernota, it)
            })
        }
    })
}

@Composable
fun ItemNota(supernotas: SuperNota, onItemSelected: (Context) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(LocalContext.current) }
            .padding(top = 8.dp, bottom = 8.dp, end = 8.dp, start = 8.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = supernotas.photo),
                contentDescription = "SuperNota Avatar",
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = supernotas.notaName,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}
