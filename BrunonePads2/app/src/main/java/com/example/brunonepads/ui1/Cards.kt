package com.example.brunonepads.ui1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.brunonepads.model.NotasItemModel
import com.example.brunonepads.viewmodel.NotasViewModel

@Composable
fun CardItem(nota: NotasItemModel, playbackViewModel: NotasViewModel) {

    val selectedImage = playbackViewModel.selectedImage.value

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxHeight()
            .fillMaxWidth()
            .clickable {
                playbackViewModel.togglePlayback(nota)
                playbackViewModel.toggleImageSelection(nota)
            },
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val imagen = if (playbackViewModel.isPlaying() && playbackViewModel.getPlayingItemId() == nota.id) {
                nota.imagenNueva
            } else {
                nota.rutaImagen
            }

            Image(
                painter = painterResource(id = selectedImage?.imagenNueva ?: imagen),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .height(72.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

