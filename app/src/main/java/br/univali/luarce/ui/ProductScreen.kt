package br.univali.luarce.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.carousel.CarouselDefaults
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.univali.luarce.R
import br.univali.luarce.ui.components.AppScaffoldWithDrawer
import br.univali.luarce.ui.components.Counter
import br.univali.luarce.ui.components.Footer
import br.univali.luarce.ui.components.ProductFeature
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(
    onBuyButtonClicked: () -> Unit = {},
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    onMainItemClicked: () -> Unit = {},
    onCatalogItemClicked: () -> Unit = {},
    onCartItemClicked: () -> Unit = {},
    onLogoutItemClicked: () -> Unit = {}
) {
    val carouselItems =
        listOf(
            R.drawable.produto,
            R.drawable.produto,
            R.drawable.produto
        )
    val carouselState = rememberCarouselState { carouselItems.count() }

    AppScaffoldWithDrawer(
        drawerState = drawerState,
        coroutineScope = coroutineScope,
        onMainItemClicked = onMainItemClicked,
        onCatalogItemClicked = onCatalogItemClicked,
        onCartItemClicked = onCartItemClicked,
        onLogoutItemClicked = onLogoutItemClicked,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .background(Color(0xFFC4C298))
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Vela Aromática",
                        color = Color(0xFFFFFFFF),
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Vanilla",
                        color = Color(0xFFFFFFFF),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(Modifier.height(20.dp))
                HorizontalUncontainedCarousel(
                    state = carouselState,
                    modifier = Modifier.width(320.dp),
                    itemWidth = 320.dp,
                    flingBehavior = CarouselDefaults
                        .singleAdvanceFlingBehavior(carouselState)
                ) {
                    Image(
                        modifier = Modifier.size(320.dp),
                        painter = painterResource(R.drawable.produto),
                        contentDescription = "Imagem do produto",
                    )
                }
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 20.dp),
                    color = Color(119, 119, 119, 191)
                )
                Column(
                    modifier = Modifier
                        .background(Color(0xFFC4C298))
                        .width(320.dp)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Volume",
                        color = Color(0xFFFFFFFF),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(Modifier.height(4.dp))
                    ProductFeature("130g")
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Pavio",
                        color = Color(0xFFFFFFFF),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(Modifier.height(4.dp))
                    Row {
                        ProductFeature("Madeira", true)
                        Spacer(Modifier.width(6.dp))
                        ProductFeature("Barbante", false)
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "R$ 40,00",
                        color = Color(0xFFFFFFFF),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.height(32.dp)
                    ) {
                        Counter()
                        Spacer(Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFFFFFFFF))
                                .border(1.dp, Color(0, 0, 0, 104))
                                .clickable { onBuyButtonClicked() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Comprar",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(17, 17, 17, 178)
                            )
                        }
                    }
                }
                Spacer(Modifier.weight(1f))
                Footer()
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun ProductPreview() {
    ProductScreen()
}
