package com.example.mycityapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.mycityapp.presentation.components.CategoryCard
import com.example.mycityapp.presentation.components.Title

@Composable
fun CategoryScreen(navController: NavHostController, categories: List<Int>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    )
    {
        Title()
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(categories) { categoryId ->
                val categoryName = stringResource(id = categoryId)
                CategoryCard(categoryName) {
                    navController.navigate("recommendations/$categoryId")
                }
            }
        }
    }
}