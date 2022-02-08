package com.kwame.nutrition.remote

import com.kwame.nutrition.remote.dtos.IngredientDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface IngredientApi {

    @GET("/api/fruit/all")
    suspend fun getIngredients() : Response<List<IngredientDto>>
}