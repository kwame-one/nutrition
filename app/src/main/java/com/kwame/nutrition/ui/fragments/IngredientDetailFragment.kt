package com.kwame.nutrition.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.kwame.nutrition.architecture.models.NutritionDetail
import com.kwame.nutrition.databinding.FragmentIngredientDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IngredientDetailFragment : Fragment(){

    private var _binding: FragmentIngredientDetailBinding? = null

    private val binding get() = _binding!!

    val nutritionDetail = NutritionDetail

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentIngredientDetailBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.name.text = nutritionDetail.name
        binding.fat.text = nutritionDetail.fat.toString()
        binding.protein.text = nutritionDetail.protein.toString()
        binding.calories.text = nutritionDetail.calories.toString()
        binding.carbohydrates.text = nutritionDetail.carbohydrates.toString()

        binding.proteinIndicator.progress =  nutritionDetail.protein.toInt()
        binding.carbohydratesIndicator.progress =  nutritionDetail.carbohydrates.toInt()
        binding.caloriesIndicator.progress =  nutritionDetail.calories.toInt()
        binding.fatIndicator.progress =  nutritionDetail.fat.toInt()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            goBack()
        }

    }

    private fun goBack() {
        NavHostFragment.findNavController(this).navigateUp()
    }
}