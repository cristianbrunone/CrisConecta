import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material.icons.outlined.Forum
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cristianconecta.data.model.DataSource.noticias
import com.example.cristianconecta.data.model.Noticia
import com.example.cristianconecta.ui.NoticiasViewModel
import com.example.nuevaaplicacion.R
import kotlinx.coroutines.launch


@Composable
fun NoticiasScreen(noticiasViewModel: NoticiasViewModel) {
    val noticias = noticiasViewModel.noticias
    ScaffoldInicio()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldInicio() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val drawerItemList = prepareNavigationDrawerItems()
    val selectedItem = remember { mutableStateOf(drawerItemList[0]) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = Color(0xFF1E1E1E), drawerContentColor = Color.Transparent, ) {
                Spacer(Modifier.height(12.dp))
                drawerItemList.forEachIndexed { index, item ->
                    Column {
                        NavigationDrawerItem(
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedTextColor = Color(0xFFECECEC),
                                unselectedTextColor = Color(0xFFECECEC),
                                unselectedBadgeColor = Color.White,
                                selectedBadgeColor = Color(0xFF1E1E1E),
                                selectedContainerColor = Color(0xFF1E1E1E),
                                unselectedContainerColor = Color(0xFF1E1E1E),
                                selectedIconColor = Color(0xFF0B3D91),
                                unselectedIconColor = Color(0xFF8C1C1C)
                            ),
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(38.dp)
                                        .height(38.dp)
                                )
                            },
                            label = {
                                Text(
                                    text = item.label,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            selected = (item == selectedItem.value),
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.close()
                                }
                                selectedItem.value = item
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                        if (index < drawerItemList.size - 1) {
                            Spacer(modifier = Modifier.height(14.dp))
                            Divider(Modifier.height(0.5.dp), color = Color.DarkGray)
                        }
                    }
                }
            }
        }

    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Agregar la imagen de fondo aquí
            Image(
                painter = painterResource(id = R.drawable.prova10),
                contentDescription = "Fondo del app",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                alpha = 5f
            )

            Scaffold(
                topBar = {
                    MyTopAppBar {
                        coroutineScope.launch { drawerState.open() }
                    }
                },
                floatingActionButtonPosition = FabPosition.End,
                containerColor = Color.Transparent
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues = paddingValues),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HorizontalRecyclerView()
                    Spacer(modifier = Modifier.padding(8.dp))
                    VerticalRecyclerView(noticias)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onNavIconClick: () -> Unit) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.ciser_logo),
                contentDescription = "logo"
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    onNavIconClick()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Open Navigation Items"
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent
        )
    )
}

@Composable
private fun prepareNavigationDrawerItems(): List<NavigationDrawerData> {
    val drawerItemsList = mutableListOf<NavigationDrawerData>()

    drawerItemsList.add(NavigationDrawerData(label = "Comunicados", icon = Icons.Outlined.Forum))
    drawerItemsList.add(
        NavigationDrawerData(
            label = "Beneficios Ciser",
            icon = Icons.Outlined.CardGiftcard
        )
    )
    drawerItemsList.add(
        NavigationDrawerData(
            label = "Calendario de \nPagamentos 2024 ",
            icon = Icons.Filled.CalendarMonth
        )
    )
    drawerItemsList.add(NavigationDrawerData(label = "Carreira", icon = Icons.Filled.Accessibility))
    drawerItemsList.add(
        NavigationDrawerData(
            label = "Contactos Úties",
            icon = Icons.Filled.Contacts
        )
    )
    drawerItemsList.add(
        NavigationDrawerData(
            label = "Etica e Integridade",
            icon = Icons.Filled.Handshake
        )
    )
    drawerItemsList.add(
        NavigationDrawerData(
            label = "Política de Gestão \nCiser",
            icon = Icons.Filled.List
        )
    )

    return drawerItemsList
}


data class NavigationDrawerData(val label: String, val icon: ImageVector)


data class BottomBarItem(val icon: ImageVector)

@Composable
fun HorizontalRecyclerView() {
    val buttons = listOf(
        " Todos ",
        "  AAC  ",
        "Benifícios",
        "Torneio FutSal",
        "Folha de Pagamento",
        "Aprender",
        "Cardapio",
        "  GMC   "
    )

    LazyRow(
        modifier = Modifier.padding(top = 25.dp)
    ) {
        items(buttons.size) { index ->
            var isSelected by remember { mutableStateOf(false) }

            OutlinedButton(
                onClick = {
                    isSelected = !isSelected
                },
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .indication(
                        interactionSource = remember {
                            MutableInteractionSource()
                        }, indication = rememberRipple(color = Color.White, radius = 16.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    contentColor = if (isSelected) {
                        Color(0xFFB71C1C) // El nombre del color debe ser específico, aquí asumo AlertDialogDefaults.backgroundColor como ejemplo
                    } else {
                        Color.White // Puedes especificar el color directamente aquí
                    },
                    containerColor = Color.Transparent
                )
            ) {
                Text(text = buttons[index], fontSize = 20.sp)
            }
        }
    }
}

@Composable
fun VerticalRecyclerView(noticias: List<Noticia>) {
    LazyColumn {
        items(noticias) { noticia ->
            Card(
                modifier = Modifier
                    .padding(vertical = 24.dp)
                    .height(185.dp)
                    .width(370.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Gray),
                shape = RoundedCornerShape(8.dp), elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Column {
                    Image(
                        painter = painterResource(id = noticia.imagenUrl), // Selecciona la imagen correspondiente
                        contentScale = ContentScale.FillWidth,
                        contentDescription = "Image description",
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                }
            }

            Box(
                modifier = Modifier
                    .height(80.dp)
                    .background(color = Color.Transparent)
            ) {
                Text(
                    text = noticia.titulo, // Selecciona el texto correspondiente
                    modifier = Modifier.padding(3.dp),
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default
                )
                Text(
                    text = noticia.fechaPublicacion,
                    modifier = Modifier.padding(top = 44.dp),
                    color = Color.White.copy(0.7f),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default
                )
            }
        }
    }
}