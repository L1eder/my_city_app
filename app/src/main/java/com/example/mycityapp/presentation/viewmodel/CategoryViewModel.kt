package com.example.mycityapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.repository.RecommendationRepository

class CategoryViewModel(repository: RecommendationRepository) : ViewModel() {
    val categories = repository.getCategories()
}