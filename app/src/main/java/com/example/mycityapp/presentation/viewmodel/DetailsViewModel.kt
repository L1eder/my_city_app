package com.example.mycityapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycityapp.data.model.Recommendation
import com.example.mycityapp.data.repository.RecommendationRepository
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: RecommendationRepository) : ViewModel() {
    var recommendation: Recommendation? = null
        private set

    fun loadRecommendation(categoryId: Int, recommendationId: Int) {
        viewModelScope.launch {
            recommendation = repository.getRecommendationById(categoryId, recommendationId)
        }
    }
}