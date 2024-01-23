package com.example.ejemplos

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    ModalNavigationDrawer(drawerContent = {
        MyDrawer {
            coroutineScope.launch {
                drawerState.close() // Cierra el cajón de navegación al hacer clic en un elemento
            }
        }
    },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar(drawerState = drawerState) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Has pulsado $it")
                    }
                }
            },
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
            bottomBar = { MyBottomNavigation() },
            floatingActionButton = { MyFAB() },
            floatingActionButtonPosition = FabPosition.End,
        ) { innerPadding ->
            // Contenido de tu pantalla va aquí, con relleno
            Text(
                text = "Contenido de tu pantalla",
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp) // Ajusta el valor según sea necesario
                    .fillMaxSize()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(drawerState: DrawerState, onClickIcon: (String) -> Unit) {
    val coroutineScope = rememberCoroutineScope()

    TopAppBar(
        title = {
            Text(
                text = "Mi primera barra de herramientas"
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch {
                    drawerState.open()
                }
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
            }

            IconButton(onClick = { onClickIcon("Clear") }) {
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
            label = { Text(text = "Fav") },
        )
        NavigationBarItem(
            selected = index == 0, onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Fav"
                )
            },
            label = { Text(text = "Fav") },
        )
        NavigationBarItem(
            selected = index == 0, onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Person"
                )
            },
            label = { Text(text = "Person") },
        )
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = { },
        containerColor = Color.Yellow,
        contentColor = Color.Black,
        shape = CircleShape
    ) {
        Icon(Icons.Filled.Add, "Añadir")
    }
}

@Composable
fun MyFABOnClick(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    // Cambié el color de fondo y el relleno del Column
    Column(Modifier.padding(8.dp).width(250.dp).height(950.dp).background(Color.White)) {
        Text(
            text = "Primera opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() },
            color = Color.Black // Cambié el color del texto a negro
        )
        Text(
            text = "Segunda opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() },
            color = Color.Black // Cambié el color del texto a negro
        )
        Text(
            text = "Tercera opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() },
            color = Color.Black // Cambié el color del texto a negro
        )
        Text(
            text = "Cuarta opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() },
            color = Color.Black // Cambié el color del texto a negro
        )
    }
}


class NavigationItem(title: String, selectedIcon: ImageVector, unselectedIcon: ImageVector) {

}

