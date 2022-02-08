package com.kwame.nutrition.architecture.repositories

import com.kwame.nutrition.listeners.FetchIngredientsListener
import com.kwame.nutrition.remote.IngredientApi
import com.kwame.nutrition.remote.dtos.toIngredient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngredientRepository @Inject constructor(
    private val ingredientApi: IngredientApi
){

    private lateinit var listener: FetchIngredientsListener

    fun setFetchIngredientListener(listener: FetchIngredientsListener) {
        this.listener  = listener
    }

    fun fetchIngredients() {
        GlobalScope.launch(Dispatchers.IO) {
            val ingredientsResponse = ingredientApi.getIngredients()

            if (ingredientsResponse.isSuccessful) {
                val ingredients = ingredientsResponse.body()!!.map { it.toIngredient() }

                println(ingredients)

                listener.onSuccess(ingredients = ingredients)
            }else {
                listener.onError(message = "Something unexpected happened, please try again later")
            }
        }


    }
}