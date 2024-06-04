package com.sport.composenavigationtest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sport.composenavigationtest.screens.DetailsScreen
import com.sport.composenavigationtest.screens.ListScreen
import com.sport.composenavigationtest.screens.PushScreen
import com.sport.composenavigationtest.screens.SearchScreen
import com.sport.composenavigationtest.ui.theme.ComposeNavigationTestTheme
import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTestTheme {
                Surface {
                    val navController = rememberNavController()
                    val bottomItems = listOf(ListScreen, SearchScreen, PushScreen)

                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                bottomItems.forEach { screen ->
                                    NavigationBarItem(
                                        selected = false,
                                        onClick = {
                                            navController.navigate(screen)
                                        },
                                        label = { Text(bottomItems.indexOf(screen).toString()) },
                                        icon = {})
                                }

                            }
                        }
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = ListScreen
                        ) {
                            composable<ListScreen> {
                                ListScreen {
                                    navController.navigate(
                                        DetailsScreen(
                                            name = it.name,
                                            age = it.age
                                        )
                                    )
                                }
                            }
                            composable<SearchScreen> { SearchScreen() }
                            composable<PushScreen> { PushScreen() }
                            composable<DetailsScreen> {
                                val args = it.toRoute<DetailsScreen>()
                                DetailsScreen(
                                    word = args.name ?: "",
                                    age = args.age,
                                    onClick = {
                                        navController.navigate(ListScreen)
                                    })
                            }
                        }
                    }
                }
            }
        }
    }
}

@Serializable
object ListScreen

@Serializable
object SearchScreen

@Serializable
object PushScreen

@Serializable
data class DetailsScreen(
    val name: String?,
    val age: Int
)