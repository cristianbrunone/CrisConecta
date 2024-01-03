@file:OptIn(ExperimentalFoundationApi::class)

package com.example.ejemplos

import android.text.Layout.Alignment
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplos.model.SuperNotas
import kotlinx.coroutines.launch

@Composable
fun SuperNotasView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperNotas()) { supernotas ->
            ItemNota(supernotas = supernotas)
            { Toast.makeText(context, it.superNotasName, Toast.LENGTH_SHORT).show() }

        }
    }
}

@Composable
fun SuperNotasStickyView() {
    val context = LocalContext.current
    val supernota: Map<String, List<SuperNotas>> = getSuperNotas().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        supernota.forEach { (publisher, mySuperNota) ->

            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
            items(mySuperNota) { supernotas ->
                ItemNota(supernotas = supernotas)
                { Toast.makeText(context, it.superNotasName, Toast.LENGTH_SHORT).show() }
            }
        }
    }
}

@Composable
fun SuperNotasWhithspecialControlsView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScop = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperNotas()) { supernotas ->
                ItemNota(supernotas = supernotas)
                { Toast.makeText(context, it.superNotasName, Toast.LENGTH_SHORT).show() }
            }
        }

        val showbutton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        rvState.firstVisibleItemScrollOffset

        if (showbutton) {
            Button(
                onClick = {
                    coroutineScop.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(alignment = CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text("Soy un Botton cool")
            }
        }

    }
}

@Composable
fun SuperNotasGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Adaptive(180.dp), content = {
        items(getSuperNotas()) { supernota ->
            ItemNota(supernotas = supernota)
            { Toast.makeText(context, it.realName, Toast.LENGTH_SHORT).show() }
        }
    }, contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp))
}

@Composable /*Pintar notas*/
fun ItemNota(supernotas: SuperNotas, onItemSelected: (SuperNotas) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Black), modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemSelected(supernotas) }
        .padding(top = 8.dp, bottom = 8.dp, end = 8.dp, start = 8.dp)) {
        Column {
            Image(
                painter = painterResource(id = supernotas.photo),
                contentDescription = "SuperNota Avatar",
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = supernotas.superNotasName,
                modifier = Modifier.align(alignment = CenterHorizontally)
            )
            Text(
                text = supernotas.superNotasName,
                modifier = Modifier.align(alignment = CenterHorizontally), fontSize = 12.sp
            )
            Text(
                text = supernotas.publisher, fontSize = 10.sp, modifier = Modifier
                    .align(alignment = End)
                    .padding(8.dp)
            )
        }
    }
}

fun getSuperNotas(): List<SuperNotas> {
    return listOf(
        SuperNotas("Nota_C", "DO", "Teclado", R.drawable.notac),
        SuperNotas("Nota_C#", "DO#", "Teclado", R.drawable.notacsostenido),
        SuperNotas("Nota_D", "RE", "Teclado", R.drawable.notad),
        SuperNotas("Nota_D#", "RE#", "Teclado", R.drawable.notadsostenido),
        SuperNotas("Nota_E", "MI", "Teclado", R.drawable.notae),
        SuperNotas("Nota_F", "FA", "Teclado", R.drawable.notaf),
        SuperNotas("Nota_F#", "FA#", "Teclado", R.drawable.notafsostenido),
        SuperNotas("Nota_G", "SOL", "Teclado", R.drawable.notag),
        SuperNotas("Nota_G#", "SOL#", "Teclado", R.drawable.notagsostenido),
        SuperNotas("Nota_A", "LA", "Teclado", R.drawable.notaa),
        SuperNotas("Nota_A#", "LA#", "Teclado", R.drawable.notaasotenido),
        SuperNotas("Nota_B", "SI", "Teclado", R.drawable.notab)
    )
}