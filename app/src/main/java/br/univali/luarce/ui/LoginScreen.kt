package br.univali.luarce.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.univali.luarce.ui.components.TopAppBarWithoutMenu

@Composable
fun LoginScreen(
    onLoginButtonClicked: () -> Unit = {},
    onRecoverPasswordButtonClicked: () -> Unit = {},
    onRegisterButtonClicked: () -> Unit = {}
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
                            text = "Login",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )


                        Text(
                            text = "Insira suas informações",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        var usuario by remember { mutableStateOf("") }
                        TextField(
                            value = usuario,
                            onValueChange = { usuario = it },
                            label = { Text("Usuário:") },
                            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                        )

                        var senha by remember { mutableStateOf("") }
                        TextField(
                            value = senha,
                            onValueChange = { senha = it },
                            label = { Text("Senha: ") },
                            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                        )

                        Button(
                            onClick = onLoginButtonClicked,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFBBB36B),
                                contentColor = Color(0xFFFFFFFF)
                            ),
                            modifier = Modifier.padding(top = 16.dp)
                                .fillMaxWidth()
                        ) {
                            Text(text = "LOGIN")
                        }


                        Text(
                            text = "Esqueceu sua senha?",
                            color = Color.Blue,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .clickable { onRecoverPasswordButtonClicked() }
                        )


                        Text(
                            text = "Não possui conta? Crie agora!",
                            color = Color.Blue,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .clickable { onRegisterButtonClicked() }
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginScreen()
}
