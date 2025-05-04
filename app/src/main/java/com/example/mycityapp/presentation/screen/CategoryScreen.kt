package com.example.mycityapp.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.mycityapp.presentation.components.CategoryCard

@Composable
fun CategoryScreen(navController: NavHostController, categories: List<Int>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(categories) { categoryId ->
            val categoryName = stringResource(id = categoryId)
            CategoryCard(categoryName) {
                navController.navigate("recommendations/$categoryId")
            }
        }
    }
}