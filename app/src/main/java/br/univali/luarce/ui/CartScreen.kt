package br.univali.luarce.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.univali.luarce.R
import br.univali.luarce.ui.components.AppScaffoldWithDrawer
import kotlinx.coroutines.CoroutineScope

data class Product(val name: String, val price: String, val quantity: Int, val image: Int)

@Composable
fun CartScreen(
    onFinishButtonClicked: () -> Unit = {},
    onInfoButtonClicked: () -> Unit = {},
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    onMainItemClicked: () -> Unit = {},
    onCatalogItemClicked: () -> Unit = {},
    onCartItemClicked: () -> Unit = {},
    onLogoutItemClicked: () -> Unit = {}
) {
    val products = listOf(
        Product("Produto 1", "R$69,90", 1, R.drawable.produto),
        Product("Produto 2", "R$39,90", 3, R.drawable.produto),
        Product("Produto 3", "R$79,90", 2, R.drawable.produto)
    )

    AppScaffoldWithDrawer(
        currentScreen = "cart",
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
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Caixa centralizada com fundo branco
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "CARRINHO",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        // Cabeçalho da tabela
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("ITEM", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text("PREÇO", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text("QTD", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        }

                        // Lista de produtos
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(products) { product ->
                                ProductRow(product)
                            }
                        }

                        // Total e botão finalizar
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Text(
                                text = "R$349,58",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }

                        Button(
                            onClick = onFinishButtonClicked,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFBBB36B),
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                        ) {
                            Text(text = "FINALIZAR COMPRA", fontSize = 14.sp)
                        }


                        Button(
                            onClick = onInfoButtonClicked,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFBBB36B),
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                        ) {
                            Text(text = "REVISAR INFORMAÇÕES", fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ProductRow(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = product.name,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(product.name, fontSize = 14.sp)
        }
        Text(product.price, fontSize = 14.sp)

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = product.quantity.toString(),
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .background(Color.White, RoundedCornerShape(4.dp))
                    .padding(horizontal = 12.dp, vertical = 2.dp),
                fontSize = 14.sp
            )
            Button(
                onClick = { /* Remover item */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(16.dp, 4.dp)
            ) {
                Text(text = "Remover", fontSize = 12.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartPreview() {
    CartScreen()
}
