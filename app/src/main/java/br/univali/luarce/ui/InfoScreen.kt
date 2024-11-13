package br.univali.luarce.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.univali.luarce.ui.components.AppScaffoldWithDrawer
import kotlinx.coroutines.CoroutineScope

@Composable
fun InfoScreen(
    onUpdateButtonClicked: () -> Unit = {},
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    onMainItemClicked: () -> Unit = {},
    onCatalogItemClicked: () -> Unit = {},
    onCartItemClicked: () -> Unit = {},
    onLogoutItemClicked: () -> Unit = {}
) {
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
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Informações de Pagamento
                Surface(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(),
                    color = Color(0xFFD9D5B8)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "1 Informações de Pagamento",
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )

                        var cpf by remember { mutableStateOf("") }
                        TextField(
                            value = cpf,
                            onValueChange = { cpf = it },
                            label = { Text("CPF", style = TextStyle(fontSize = 12.sp)) },
                            textStyle = TextStyle(fontSize = 12.sp),
                            modifier = Modifier.fillMaxWidth()
                        )

                        var numeroCartao by remember { mutableStateOf("") }
                        TextField(
                            value = numeroCartao,
                            onValueChange = { numeroCartao = it },
                            label = { Text("Número do Cartão", style = TextStyle(fontSize = 12.sp)) },
                            textStyle = TextStyle(fontSize = 12.sp),
                            modifier = Modifier.fillMaxWidth()
                        )

                        var codigoSeg by remember { mutableStateOf("") }
                        TextField(
                            value = codigoSeg,
                            onValueChange = { codigoSeg = it },
                            label = { Text("Código de Segurança", style = TextStyle(fontSize = 12.sp)) },
                            textStyle = TextStyle(fontSize = 12.sp),
                            modifier = Modifier.fillMaxWidth()
                        )

                        var validade by remember { mutableStateOf("") }
                        TextField(
                            value = validade,
                            onValueChange = { validade = it },
                            label = { Text("Data de Validade", style = TextStyle(fontSize = 12.sp)) },
                            textStyle = TextStyle(fontSize = 12.sp),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                // Endereço de Entrega
                Surface(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(),
                    color = Color(0xFFD9D5B8)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "2 Entrega",
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )

                        var cep by remember { mutableStateOf("") }
                        TextField(
                            value = cep,
                            onValueChange = { cep = it },
                            label = { Text("CEP", style = TextStyle(fontSize = 12.sp)) },
                            textStyle = TextStyle(fontSize = 12.sp),
                            modifier = Modifier.fillMaxWidth()
                        )

                        var estado by remember { mutableStateOf("") }
                        TextField(
                            value = estado,
                            onValueChange = { estado = it },
                            label = { Text("Estado", style = TextStyle(fontSize = 12.sp)) },
                            textStyle = TextStyle(fontSize = 12.sp),
                            modifier = Modifier.fillMaxWidth()
                        )

                        var cidade by remember { mutableStateOf("") }
                        TextField(
                            value = cidade,
                            onValueChange = { cidade = it },
                            label = { Text("Cidade", style = TextStyle(fontSize = 12.sp)) },
                            textStyle = TextStyle(fontSize = 12.sp),
                            modifier = Modifier.fillMaxWidth()
                        )

                        var endereco by remember { mutableStateOf("") }
                        TextField(
                            value = endereco,
                            onValueChange = { endereco = it },
                            label = { Text("Endereço", style = TextStyle(fontSize = 12.sp)) },
                            textStyle = TextStyle(fontSize = 12.sp),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                Button(
                    onClick = onUpdateButtonClicked,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFBBB36B),
                        contentColor = Color.White
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Cadastrar Informações")
                }
            }
        } // Fechando o content do Scaffold
    )
}

@Preview(showBackground = true)
@Composable
fun InfoPreview() {
    InfoScreen()
}
