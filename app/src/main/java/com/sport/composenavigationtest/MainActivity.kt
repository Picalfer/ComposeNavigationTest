package com.sport.composenavigationtest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sport.composenavigationtest.screens.DetailsScreen
import com.sport.composenavigationtest.screens.ListScreen
import com.sport.composenavigationtest.screens.PushScreen
import com.sport.composenavigationtest.screens.SearchScreen
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
                            composable("list") {
                                ListScreen {
                                    navController.navigate("details/$it")
                                }
                            }
                            composable("search") { SearchScreen() }
                            composable("push") { PushScreen() }
                            composable("details/{word}") { backStackEntry ->
                                val word: String = backStackEntry.arguments?.getString("word") ?: ""
                                DetailsScreen(word = word,
                                    onClick = {
                                        navController.navigate("list")
                                    })
                            }
                        }
                    }
                }
            }
        }
    }
}
