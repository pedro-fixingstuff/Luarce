package br.univali.luarce.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.univali.luarce.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

@Composable
fun AppScaffoldWithDrawer(
    currentScreen: String = "",
    content: @Composable () -> Unit,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
    navController: NavHostController
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RectangleShape
            ) {
                NavigationDrawerItem(
                    label = { Text(text = "Início") },
                    selected = currentScreen == "main",
                    onClick = { navController.navigate("main") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Início"
                        )
                    },
                    shape = RectangleShape,
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color(0xFFC4C298)
                    )
                )
                NavigationDrawerItem(
                    label = { Text(text = "Catálogo") },
                    selected = currentScreen == "catalog",
                    onClick = { navController.navigate("catalog") },
                    icon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.List,
                            contentDescription = "Início"
                        )
                    },
                    shape = RectangleShape,
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color(0xFFC4C298)
                    )
                )
                NavigationDrawerItem(
                    label = { Text(text = "Carrinho") },
                    selected = currentScreen == "cart",
                    onClick = { navController.navigate("cart") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Carrinho"
                        )
                    },
                    shape = RectangleShape,
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color(0xFFC4C298)
                    )
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Sair") },
                    selected = false,
                    onClick = { navController.navigate("login") },
                    icon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Sair"
                        )
                    },
                    shape = RectangleShape,
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color(0xFFC4C298)
                    )
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(drawerState, coroutineScope)
            },
            bottomBar = {
                BottomAppBar(navController)
            },
            containerColor = Color(0xFFF7F6EF),
            content = { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    content()
                }
            }
        )
    }
}

@Composable
fun TopAppBar(drawerState: DrawerState, coroutineScope: CoroutineScope) {
    androidx.compose.material.TopAppBar(
        modifier = Modifier.height(72.dp),
        title = {
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = "Luarce",
            )
        },
        backgroundColor = Color(0xFFFFFFFF),
        actions = {
            IconButton(
                modifier = Modifier.padding(end = 8.dp),
                onClick = {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier.size(40.dp),
                    tint = Color(0xFF747474)
                )
            }
        }
    )
}

@Composable
fun TopAppBarWithoutMenu() {
    androidx.compose.material.TopAppBar(
        modifier = Modifier.height(72.dp),
        title = {
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = "Luarce",
            )
        },
        backgroundColor = Color(0xFFFFFFFF)
    )
}

@Composable
fun BottomAppBar(navController: NavHostController) {
    androidx.compose.material.BottomAppBar(
        modifier = Modifier.height(72.dp),
        backgroundColor = Color(0xFFFFFFFF),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.navigate("cart") }) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Carrinho",
                    modifier = Modifier.size(40.dp),
                    tint = Color(0xFF747474)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favoritos",
                    modifier = Modifier.size(40.dp),
                    tint = Color(0xFF747474)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Usuário",
                    modifier = Modifier.size(40.dp),
                    tint = Color(0xFF747474)
                )
            }
        }
    }
}

@Composable
fun Footer() {

}

@Composable
fun SectionHeader(text: String) {
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        Spacer(Modifier.height(8.dp))
        Text(
            text = text,
            color = Color(0xFF333333),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(8.dp))
        HorizontalDivider(
            color = Color(119, 119, 119, 191)
        )
    }
}

@Composable
fun ProductCard(name: String, price: Double, navController: NavHostController) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(180.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0xFFC4C4C4))
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                text = name,
                color = Color(0, 0, 0, 166),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = NumberFormat
                    .getCurrencyInstance(Locale("pt", "BR"))
                    .format(price),
                color = Color(0, 0, 0, 166),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE2E1CC))
                    .clickable { navController.navigate("product") }
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Comprar",
                    color = Color(0, 0, 0, 166),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ProductIcon(name: String) {
    Column(
        modifier = Modifier.clickable {},
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0xFFC4C4C4))
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = name,
            color = Color(0, 0, 0, 166),
            fontSize = 12.sp
        )
    }
}

@Composable
fun ProductFeature(text: String, status: Boolean = true) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .clip(CircleShape)
                .background(Color(0xFFFFFFFF)),
            contentAlignment = Alignment.Center
        ) {
            if (status) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(Color(94, 94, 94, 204))
                )
            }
        }
        Spacer(Modifier.width(6.dp))
        androidx.compose.material.Text(
            text = text,
            color = Color(0xFFFFFFFF),
            fontSize = 16.sp
        )
    }
}

@Composable
fun Counter() {
    var count by remember { mutableIntStateOf(1) }

    Row(
        modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .border(1.dp, Color(0, 0, 0, 104)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = {
            if (count > 0) count--
        }) {
            Text(
                text = "-",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(17, 17, 17, 178)
            )
        }
        Spacer(Modifier.width(12.dp))
        Text(
            text = count.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(17, 17, 17, 178)
        )
        Spacer(Modifier.width(12.dp))
        IconButton(
            onClick = { count++ },
        ) {
            Text(
                text = "+",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(17, 17, 17, 178)
            )
        }
    }
}
