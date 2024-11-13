package br.univali.luarce.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.univali.luarce.ui.components.TopAppBarWithoutMenu

@Composable
fun RecoverPasswordScreen(
    onRedefineButtonClicked: () -> Unit = {}
) {
    Scaffold(
        topBar = { TopAppBarWithoutMenu() },
        containerColor = Color(0xFFECE8C6),
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .padding(16.dp),
                    color = Color.White,
                    shadowElevation = 4.dp
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Esqueceu sua Senha?",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        var novaSenha by remember { mutableStateOf("") }
                        TextField(
                            value = novaSenha,
                            onValueChange = { novaSenha = it },
                            label = { Text("Nova Senha") }
                        )

                        var confirmarSenha by remember { mutableStateOf("") }
                        TextField(
                            value = confirmarSenha,
                            onValueChange = { confirmarSenha = it },
                            label = { Text("Confirmar Senha") }
                        )

                        Button(
                            onClick = onRedefineButtonClicked,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFBBB36B),
                                contentColor = Color(0xFFFFFFFF)
                            ),
                            modifier = Modifier.padding(top = 16.dp)
                        ) {
                            Text(text = "Redefinir Senha")
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun RecoverPasswordPreview() {
    RecoverPasswordScreen()
}
