package br.univali.luarce.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.carousel.CarouselDefaults
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import br.univali.luarce.ui.components.AppScaffoldWithDrawer
import br.univali.luarce.ui.components.Footer
import br.univali.luarce.ui.components.ProductCard
import br.univali.luarce.ui.components.ProductIcon
import br.univali.luarce.ui.components.SectionHeader
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onProductCardClicked: () -> Unit = {},
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    onCatalogItemClicked: () -> Unit = {},
    onCartItemClicked: () -> Unit = {},
    onLogoutItemClicked: () -> Unit = {}
) {
    val carouselItems =
        listOf(
            Color(159, 127, 127),
            Color(127, 159, 127),
            Color(127, 127, 159)
        )
    val carouselState = rememberCarouselState { carouselItems.count() }

    AppScaffoldWithDrawer(
        currentScreen = "main",
        drawerState = drawerState,
        coroutineScope = coroutineScope,
        onCatalogItemClicked = onCatalogItemClicked,
        onCartItemClicked = onCartItemClicked,
        onLogoutItemClicked = onLogoutItemClicked,
        content = {
            Column(
                modifier = Modifier
                    .background(Color(0xFFC4C298))
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                HorizontalUncontainedCarousel(
                    state = carouselState,
                    modifier = Modifier.fillMaxWidth(),
                    itemWidth = LocalConfiguration.current.screenWidthDp.dp,
                    flingBehavior = CarouselDefaults
                        .singleAdvanceFlingBehavior(carouselState)
                ) { i ->
                    Box(
                        modifier = Modifier
                            .background(carouselItems[i])
                            .fillMaxWidth()
                            .height(180.dp)
                    )
                }
                SectionHeader("Descubra por Categorias")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ProductIcon("Categoria 1")
                    ProductIcon("Categoria 2")
                    ProductIcon("Categoria 3")
                    ProductIcon("Categoria 4")
                }
                SectionHeader("Destaques")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProductCard("Produto 1", 40.00, onProductCardClicked)
                    ProductCard("Produto 2", 40.00, onProductCardClicked)
                    ProductCard("Produto 3", 40.00, onProductCardClicked)
                }
                SectionHeader("Ideias de Presente")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProductCard("Produto 1", 40.00, onProductCardClicked)
                    ProductCard("Produto 2", 40.00, onProductCardClicked)
                    ProductCard("Produto 3", 40.00, onProductCardClicked)
                }
                Spacer(Modifier.weight(1f))
                Footer()
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}
