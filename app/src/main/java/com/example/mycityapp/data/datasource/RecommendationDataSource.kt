package com.example.mycityapp.data.datasource

import com.example.mycityapp.R
import com.example.mycityapp.data.model.Recommendation

class RecommendationDataSource {
    private val categories = listOf(
        R.string.category_cafe,
        R.string.category_restaurants,
        R.string.category_places,
        R.string.category_parks,
        R.string.category_shop_centers
    )

    private val recommendations = mapOf(
        R.string.category_cafe to listOf(
            Recommendation(
                id = 1,
                nameResId = R.string.category_cafe_1,
                descriptionResId = R.string.category_cafe_1_description,
                imageResId = R.drawable.category_cafe_1
            ),
            Recommendation(
                id = 2,
                nameResId = R.string.category_cafe_2,
                descriptionResId = R.string.category_cafe_2_description,
                imageResId = R.drawable.category_cafe_2
            ),
            Recommendation(
                id = 3,
                nameResId = R.string.category_cafe_3,
                descriptionResId = R.string.category_cafe_3_description,
                imageResId = R.drawable.category_cafe_3
            ),
            Recommendation(
                id = 4,
                nameResId = R.string.category_cafe_4,
                descriptionResId = R.string.category_cafe_4_description,
                imageResId = R.drawable.category_cafe_4
            ),
            Recommendation(
                id = 5,
                nameResId = R.string.category_cafe_5,
                descriptionResId = R.string.category_cafe_5_description,
                imageResId = R.drawable.category_cafe_5
            )
        ),
        R.string.category_restaurants to listOf(
            Recommendation(
                id = 1,
                nameResId = R.string.category_cafe_1,
                descriptionResId = R.string.category_cafe_1_description,
                imageResId = R.drawable.category_cafe_1
            ),
            Recommendation(
                id = 2,
                nameResId = R.string.category_cafe_2,
                descriptionResId = R.string.category_cafe_2_description,
                imageResId = R.drawable.category_cafe_2
            ),
            Recommendation(
                id = 3,
                nameResId = R.string.category_cafe_3,
                descriptionResId = R.string.category_cafe_3_description,
                imageResId = R.drawable.category_cafe_3
            ),
            Recommendation(
                id = 4,
                nameResId = R.string.category_cafe_4,
                descriptionResId = R.string.category_cafe_4_description,
                imageResId = R.drawable.category_cafe_4
            ),
            Recommendation(
                id = 5,
                nameResId = R.string.category_cafe_5,
                descriptionResId = R.string.category_cafe_5_description,
                imageResId = R.drawable.category_cafe_5
            )
        )
    )

    fun getCategories() = categories

    fun getRecommendations(categoryId: Int): List<Recommendation> {
        return recommendations[categoryId] ?: emptyList()
    }

    fun getRecommendationById(categoryId: Int, recommendationId: Int): Recommendation? {
        return recommendations[categoryId]?.find { it.id == recommendationId }
    }
}