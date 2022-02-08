package com.kwame.nutrition.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kwame.nutrition.databinding.FragmentIngredientDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IngredientDetailFragment : Fragment(){

    private var _binding: FragmentIngredientDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentIngredientDetailBinding.inflate(inflater, container, false);
        return binding.root
    }
}