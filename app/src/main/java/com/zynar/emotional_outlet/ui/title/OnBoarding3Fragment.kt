package com.zynar.emotional_outlet.ui.title

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.zynar.emotional_outlet.R
import com.zynar.emotional_outlet.databinding.FragmentOnBoarding3Binding
import com.zynar.emotional_outlet.helpers.enums.Shared


class OnBoarding3Fragment : Fragment() {

    private var binding : FragmentOnBoarding3Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoarding3Binding.inflate(inflater, container, false)

        binding!!.btnNext.setOnClickListener {
            val preferences = activity?.getSharedPreferences("asd", Context.MODE_PRIVATE)
            preferences!!.edit().putInt(Shared.ON_BOARDING.name, 1).apply()
            val navController = Navigation.findNavController(binding!!.root)
            navController.navigate(R.id.titleFragment)
        }
        return binding!!.root
    }

}