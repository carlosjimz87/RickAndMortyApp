package com.example.rickandmortyapp.ui.views.details

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.rickandmortyapp.ui.views.list.ListViewModel

@Composable
fun DetailsScreen(
    characterId: Int,
    navController: NavController,
    viewModel: DetailsViewModel = viewModel()
) {

}