package com.kwame.nutrition.listeners

import com.kwame.nutrition.architecture.models.Ingredient

interface FetchIngredientsListener {

    fun onSuccess(ingredients: List<Ingredient>)

    fun onError(message: String)
}