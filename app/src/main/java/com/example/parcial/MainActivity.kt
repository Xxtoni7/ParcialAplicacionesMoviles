package com.example.parcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.parcial.ui.theme.ParcialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ParcialTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "Principal"
                ) {
                    composable("Principal") {
                        PantallaPrincipal(navController)
                    }
                    composable(
                        "Comprobante/{monto}",
                        arguments = listOf(navArgument("monto") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val monto = backStackEntry.arguments?.getInt("monto") ?: 0
                        Comprobante(monto, navController)
                    }
                }
            }
        }
    }
}
