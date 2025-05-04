package com.example.mycityapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycityapp.data.model.Recommendation
import com.example.mycityapp.data.repository.RecommendationRepository
import kotlinx.coroutines.launch

class RecommendationsViewModel(private val repository: RecommendationRepository) : ViewModel() {
    private val _recommendations = mutableListOf<Recommendation>()
    val recommendations: List<Recommendation> get() = _recommendations

    fun loadRecommendations(categoryId: Int) {
        viewModelScope.launch {
            _recommendations.clear()
            _recommendations.addAll(repository.getRecommendations(categoryId))
        }
    }
}