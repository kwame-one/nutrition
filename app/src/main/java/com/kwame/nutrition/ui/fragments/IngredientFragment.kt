package com.kwame.nutrition.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kwame.nutrition.R
import com.kwame.nutrition.adapter.IngredientAdapter
import com.kwame.nutrition.architecture.models.NutritionDetail
import com.kwame.nutrition.architecture.viewmodels.IngredientViewModel
import com.kwame.nutrition.databinding.FragmentIngredientBinding
import com.kwame.nutrition.listeners.ItemClickListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class IngredientFragment : Fragment() {

    private var _binding: FragmentIngredientBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private val ingredientViewModel: IngredientViewModel by viewModels()

    val nutritionDetail = NutritionDetail

    @Inject
    lateinit var adapter: IngredientAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentIngredientBinding.inflate(inflater, container, false);
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerViewIngredients
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireView().context, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(requireView().context, LinearLayoutManager.VERTICAL))

        recyclerView.adapter = adapter

        binding.refresh.isRefreshing = true

        ingredientViewModel.fetchIngredients()

        ingredientViewModel.ingredientState.observe(viewLifecycleOwner) {
            binding.refresh.isRefreshing = false
            adapter.setIngredients(it)
            adapter.notifyDataSetChanged()
        }

        ingredientViewModel.errorMessageState.observe(viewLifecycleOwner) {
            binding.refresh.isRefreshing = false
            Toast.makeText(requireView().context, it, Toast.LENGTH_SHORT).show()
        }

        binding.refresh.setOnRefreshListener {
            ingredientViewModel.fetchIngredients()
        }

        adapter.setOnItemClickListener(object: ItemClickListener {
            override fun onItemClick(position: Int) {

                val ingredient = adapter.getIngredient(position)

                nutritionDetail.calories = ingredient?.nutrition?.calories ?: 0.0
                nutritionDetail.carbohydrates = ingredient?.nutrition?.carbohydrates ?: 0.0
                nutritionDetail.fat = ingredient?.nutrition?.fat ?: 0.0
                nutritionDetail.protein = ingredient?.nutrition?.protein ?: 0.0
                nutritionDetail.name = ingredient!!.name

                showDetails()
            }

        })


    }

    fun showDetails() {
        NavHostFragment.findNavController(this).navigate(R.id.navigation_ingredient_detail)
    }
}