package com.sport.composenavigationtest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sport.composenavigationtest.ui.theme.ComposeNavigationTestTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTestTheme {
                Surface {
                    val navController = rememberNavController()
                    val bottomItems = listOf("list", "search", "push")

                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                bottomItems.forEach { screen ->
                                    NavigationBarItem(
                                        selected = false,
                                        onClick = {
                                            navController.navigate(screen)
                                        },
                                        label = { Text(screen) },
                                        icon = {})
                                }

                            }
                        }
                    ) {
                        NavHost(navController = navController, startDestination = "list") {
                            composable("list") { Text("list", modifier = Modifier.padding(24.dp)) }
                            composable("search") { Text("search", modifier = Modifier.padding(24.dp)) }
                            composable("push") { Text("push", modifier = Modifier.padding(24.dp)) }
                        }
                    }
                }
            }
        }
    }
}
