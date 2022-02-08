package com.kwame.nutrition.architecture.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kwame.nutrition.architecture.models.Ingredient
import com.kwame.nutrition.architecture.repositories.IngredientRepository
import com.kwame.nutrition.listeners.FetchIngredientsListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IngredientViewModel @Inject constructor(
   private val ingredientRepository: IngredientRepository
) : ViewModel(), FetchIngredientsListener {

   init {
       ingredientRepository.setFetchIngredientListener(this)
   }

   val ingredientState = MutableLiveData<List<Ingredient>>()
   val errorMessageState = MutableLiveData<String>()


   fun fetchIngredients() {
      ingredientRepository.fetchIngredients()
   }

   override fun onSuccess(ingredients: List<Ingredient>) {
      ingredientState.postValue(ingredients)
   }

   override fun onError(message: String) {
      errorMessageState.postValue(message)
   }

}