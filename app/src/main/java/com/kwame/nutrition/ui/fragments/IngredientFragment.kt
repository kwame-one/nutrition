package com.kwame.nutrition.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kwame.nutrition.databinding.FragmentIngredientBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IngredientFragment : Fragment() {

    private var _binding: FragmentIngredientBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentIngredientBinding.inflate(inflater, container, false);
        return binding.root
    }
}