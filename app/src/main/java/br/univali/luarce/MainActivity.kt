import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
                color = MaterialTheme.colors.background
            ) {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {
                    composable("main") {
                        MainScreen(navController)
                    }
                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("register") {
                        RegisterScreen(navController)
                    }
                    composable("recoverPassword") {
                        RecoverPasswordScreen(navController)
                    }
                    composable("catalog") {
                        CatalogScreen(navController)
                    }
                    composable("product") {
                        ProductScreen(navController)
                    }
                    composable("cart") {
                        CartScreen(navController)
                    }
                    composable("info") {
                        InfoScreen(navController)
                    }
                }
            }
        }
    }
}
