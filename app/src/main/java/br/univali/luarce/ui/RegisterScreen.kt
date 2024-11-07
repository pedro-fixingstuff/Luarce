package br.univali.luarce.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.univali.luarce.ui.components.TopAppBarWithoutMenu

@Composable
fun RegisterScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBarWithoutMenu() },
        containerColor = Color(0xFFECE8C6), // alterado para containerColor
        content = { paddingValues ->

            // Caixa de criação de conta centralizada
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues) // Aplica o padding do Scaffold
                    .padding(16.dp), // Padding adicional
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White), // Adicionando a cor de fundo diretamente
                    color = Color.White,

                    ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Criando sua conta",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        var name by remember { mutableStateOf("") }
                        TextField(
                            value = name,
                            onValueChange = { newValue -> name = newValue },
                            modifier = Modifier.padding(8.dp),
                            label = { Text("Nome: ") },
                            leadingIcon = {
                                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Nome do usuário")
                            }
                        )

                        var email by remember { mutableStateOf("") }
                        TextField(
                            value = email,
                            onValueChange = { newValue -> email = newValue },
                            modifier = Modifier.padding(8.dp),
                            label = { Text("Email: ") },
                            leadingIcon = {
                                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Email do usuário")
                            }
                        )

                        var password by remember { mutableStateOf("") }
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            modifier = Modifier.padding(8.dp),
                            label = { Text("Senha: ") },
                            visualTransformation = PasswordVisualTransformation(),
                            leadingIcon = {
                                Icon(imageVector = Icons.Default.Create, contentDescription = "Senha do usuário")
                            }
                        )

                        var confirmpassword by remember { mutableStateOf("") }
                        TextField(
                            value = confirmpassword,
                            onValueChange = { confirmpassword = it },
                            modifier = Modifier.padding(8.dp),
                            label = { Text("Confirme a Senha: ") },
                            visualTransformation = PasswordVisualTransformation(),
                            leadingIcon = {
                                Icon(imageVector = Icons.Default.Create, contentDescription = "Confirmação de senha do usuário")
                            }
                        )

                        Button(
                            onClick = { navController.navigate("main") },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFBBB36B), // alterado para containerColor
                                contentColor = Color.White // Texto branco
                            ),
                            modifier = Modifier.padding(top = 16.dp)
                        ) {
                            Text(text = "Finalizar")
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    RegisterScreen(rememberNavController())
}
