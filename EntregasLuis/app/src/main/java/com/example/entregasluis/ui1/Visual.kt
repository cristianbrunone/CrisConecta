package com.example.entregasluis.ui1


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch




@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ScaffoldExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var isCardExpanded by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = {
                    Snackbar(
                        snackbarData = it,
                        containerColor = Color.LightGray,
                        contentColor = Color.Blue
                    )
                }
            )
        },
        bottomBar = { MyBottomNavigation() }
    ) { innerPadding ->
        // Contenido de tu pantalla va aquí, con relleno
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp) // Ajusta el valor según sea necesario
        ) {
            item {
                MyTopAppBar {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Has pulsado $it")
                    }
                }
            }

            item {
                MapViewContainer()
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(if (isCardExpanded) 200.dp else 100.dp)
                ) {
                    // Contenido de la Card, por ejemplo, las sugerencias de búsqueda
                    Text(
                        text = "Sugerencias de búsqueda",
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Mi primera barra de herramientas"
            )
        },
        navigationIcon = {
            IconButton(onClick = { onClickIcon("Atras") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Volver")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
            }

            IconButton(onClick = { onClickIcon("CLear") }) {
                Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear")
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Red, // Color de fondo de la barra superior
            titleContentColor = Color.Yellow, //Color del contenido
            navigationIconContentColor = Color.White, // Color del contenido de la barra superior (títulos, iconos)
            actionIconContentColor = Color.White,


            )
    )
}


@Composable
fun MyBottomNavigation() {
    var index by remember {
        mutableStateOf(0)
    }
    NavigationBar(containerColor = Color.DarkGray, contentColor = Color.White) {
        NavigationBarItem(
            selected = index == 0, onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text(text = "Fav") },)
        NavigationBarItem(
            selected = index == 0, onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Fav"
                )
            },
            label = { Text(text = "Fav") },)
        NavigationBarItem(
            selected = index == 0, onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Person"
                )
            },
            label = { Text(text = "Person") },)
    }
}

@Composable
fun MapViewContainer() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            val mapView = MapView(context)
            mapView
        },
        update = { mapView ->
            // Configurar opciones del mapa si es necesario
            val location = LatLng(-34.0, 151.0) // Coordenadas de ejemplo (Sidney, Australia)
            mapView.getMapAsync { googleMap ->
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(location))
            }
        }
    )
}



