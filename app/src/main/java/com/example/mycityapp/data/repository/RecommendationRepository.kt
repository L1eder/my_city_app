package com.example.mycityapp.data.repository

import com.example.mycityapp.data.datasource.RecommendationDataSource

class RecommendationRepository(private val dataSource: RecommendationDataSource) {
    fun getCategories() = dataSource.getCategories()
    fun getRecommendations(categoryId: Int) = dataSource.getRecommendations(categoryId)
}