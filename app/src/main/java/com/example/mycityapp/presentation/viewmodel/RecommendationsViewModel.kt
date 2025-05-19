package com.example.mycityapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.model.Recommendation
import com.example.mycityapp.data.repository.RecommendationRepository

class RecommendationsViewModel(private val repository: RecommendationRepository) : ViewModel() {
    private val _recommendations = mutableListOf<Recommendation>()
    val recommendations: List<Recommendation> get() = _recommendations

    fun loadRecommendations(categoryId: Int) {
        _recommendations.clear()
        _recommendations.addAll(repository.getRecommendations(categoryId))
    }
}