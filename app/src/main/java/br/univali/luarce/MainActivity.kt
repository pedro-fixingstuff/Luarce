import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.univali.luarce.ui.CartScreen
import br.univali.luarce.ui.CatalogScreen
import br.univali.luarce.ui.InfoScreen
import br.univali.luarce.ui.LoginScreen
import br.univali.luarce.ui.MainScreen
import br.univali.luarce.ui.ProductScreen
import br.univali.luarce.ui.RecoverPasswordScreen
import br.univali.luarce.ui.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val navController = rememberNavController()

                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val coroutineScope = rememberCoroutineScope()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("main") {
                        MainScreen(
                            onProductCardClicked = { navController.navigate("product") },
                            drawerState = drawerState,
                            coroutineScope = coroutineScope,
                            onCatalogItemClicked = { navController.navigate("catalog") },
                            onCartItemClicked = { navController.navigate("cart") },
                            onLogoutItemClicked = { navController.navigate("login") }
                        )
                    }
                    composable("login") {
                        LoginScreen(
                            { navController.navigate("main") },
                            { navController.navigate("recoverPassword") },
                            { navController.navigate("register") }
                        )
                    }
                    composable("register") {
                        RegisterScreen { navController.navigate("main") }
                    }
                    composable("recoverPassword") {
                        RecoverPasswordScreen { navController.navigate("main") }
                    }
                    composable("catalog") {
                        CatalogScreen(
                            onProductCardClicked = { navController.navigate("product") },
                            drawerState = drawerState,
                            coroutineScope = coroutineScope,
                            onMainItemClicked = { navController.navigate("main") },
                            onCartItemClicked = { navController.navigate("cart") },
                            onLogoutItemClicked = { navController.navigate("login") }
                        )
                    }
                    composable("product") {
                        ProductScreen(
                            onBuyButtonClicked = { navController.navigate("cart") },
                            onMainItemClicked = { navController.navigate("main") },
                            onCatalogItemClicked = { navController.navigate("catalog") },
                            onCartItemClicked = { navController.navigate("cart") },
                            onLogoutItemClicked = { navController.navigate("login") }
                        )
                    }
                    composable("cart") {
                        CartScreen(
                            onFinishButtonClicked = { navController.navigate("main") },
                            onInfoButtonClicked = { navController.navigate("info") },
                            onMainItemClicked = { navController.navigate("main") },
                            onCatalogItemClicked = { navController.navigate("catalog") },
                            onLogoutItemClicked = { navController.navigate("login") }
                        )
                    }
                    composable("info") {
                        InfoScreen(
                            onUpdateButtonClicked = { navController.navigate("cart") },
                            onMainItemClicked = { navController.navigate("main") },
                            onCatalogItemClicked = { navController.navigate("catalog") },
                            onCartItemClicked = { navController.navigate("cart") },
                            onLogoutItemClicked = { navController.navigate("login") }
                        )
                    }
                }
            }
        }
    }
}
