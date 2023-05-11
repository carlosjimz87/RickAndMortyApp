package com.example.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import com.example.rickandmortyapp.ui.views.details.DetailsScreen
import com.example.rickandmortyapp.ui.views.list.ListScreen
import com.example.rickandmortyapp.ui.views.list.ListViewModel
import com.example.rickandmortyapp.utils.Constants.DETAILS_SCREEN_NAME
import com.example.rickandmortyapp.utils.Constants.LIST_SCREEN_NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = LIST_SCREEN_NAME
                ) {
                    composable(LIST_SCREEN_NAME) {

                        val viewModel = hiltViewModel<ListViewModel>()
                        ListScreen(navController,viewModel)
                    }

                    composable(
                        "$DETAILS_SCREEN_NAME/{id}",
                        arguments = listOf(
                            navArgument("id") {
                                type = NavType.IntType
                            }
                        )
                    ) {
                        val characterId = remember {
                            it.arguments?.getInt("id")
                        } ?: 0
                        DetailsScreen(
                            navController = navController
                        )
                    }
                }
            }
        }


    }
}
