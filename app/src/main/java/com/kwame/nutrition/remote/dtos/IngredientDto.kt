package com.kwame.nutrition.remote.dtos

import com.google.gson.annotations.SerializedName
import com.kwame.nutrition.architecture.models.Ingredient

data class IngredientDto (

    @SerializedName("genus") val genus: String,
    @SerializedName("name") val name: String,
    @SerializedName("nutritions") val nutritions : NutritionDto

)

fun IngredientDto.toIngredient(): Ingredient {
    return Ingredient(
        name = name,
        genus = genus,
        nutrition = nutritions.toNutrition()
    )
}