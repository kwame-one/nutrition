package com.kwame.nutrition.remote.dtos

import com.google.gson.annotations.SerializedName
import com.kwame.nutrition.architecture.models.Nutrition

data class NutritionDto (
    @SerializedName("carbohydrates") val carbohydrates: Double,
    @SerializedName("protein") val protein: Double,
    @SerializedName("fat") val fat: Double,
    @SerializedName("calories") val calories: Double,
    @SerializedName("sugar") val sugar: Double
)

fun NutritionDto.toNutrition() : Nutrition {
    return Nutrition(
        carbohydrates = carbohydrates,
        protein = protein,
        fat = fat,
        calories = calories,
        sugar =sugar

    )
}