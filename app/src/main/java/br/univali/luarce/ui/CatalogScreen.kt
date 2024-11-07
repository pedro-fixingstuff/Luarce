package br.univali.luarce.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.univali.luarce.ui.components.AppScaffoldWithDrawer
import br.univali.luarce.ui.components.Footer
import br.univali.luarce.ui.components.ProductCard

@Composable
fun CatalogScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    AppScaffoldWithDrawer(
        currentScreen = "catalog",
        drawerState = drawerState,
        coroutineScope = coroutineScope,
        navController = navController,
        content = {
            Column(
                modifier = Modifier
                    .background(Color(0xFFF7F6EF))
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                CatalogHeader()
                Spacer(Modifier.height(40.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProductCard("Produto 1", 40.00, navController)
                    ProductCard("Produto 2", 40.00, navController)
                    ProductCard("Produto 3", 40.00, navController)
                }
                Spacer(Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProductCard("Produto 4", 40.00, navController)
                    ProductCard("Produto 5", 40.00, navController)
                    ProductCard("Produto 6", 40.00, navController)
                }
                Spacer(Modifier.weight(1f))
                Footer()
            }
        },
    )
}

@Composable
fun CatalogHeader() {
    Box(
        modifier = Modifier
            .background(Color(0xFFC4C298))
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Catálogo",
                color = Color(0xFFFFFFFF),
                fontSize = 24.sp
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Explore a coleção completa de nossos aromas e encontre a vela perfeita para qualquer ambiente e ocasião",
                color = Color(0xFFFFFFFF),
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CatalogPreview() {
    CatalogScreen(rememberNavController())
}
