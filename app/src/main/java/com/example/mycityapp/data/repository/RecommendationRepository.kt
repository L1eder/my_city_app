package com.example.mycityapp.data.repository

import com.example.mycityapp.data.datasource.RecommendationDataSource
import com.example.mycityapp.data.model.Recommendation

class RecommendationRepository(private val dataSource: RecommendationDataSource) {
    fun getCategories() = dataSource.getCategories()
    fun getRecommendations(categoryId: Int) = dataSource.getRecommendations(categoryId)
    fun getRecommendationById(categoryId: Int, recommendationId: Int): Recommendation? {
        return dataSource.getRecommendationById(categoryId, recommendationId)
    }
}