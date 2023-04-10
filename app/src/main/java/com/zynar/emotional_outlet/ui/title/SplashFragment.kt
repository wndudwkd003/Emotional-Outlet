package com.zynar.emotional_outlet.ui.title

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.zynar.emotional_outlet.R
import com.zynar.emotional_outlet.databinding.FragmentSplashBinding
import com.zynar.emotional_outlet.helpers.enums.Shared

class SplashFragment : Fragment() {

    private var binding : FragmentSplashBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSplashBinding.inflate(inflater, container, false)

        val handler = Handler()
        handler.postDelayed({
            val navController = Navigation.findNavController(binding!!.root)
            if (isFinished == 1) {
                navController.navigate(R.id.titleFragment)
            } else {
                navController.navigate(R.id.onBoardingFragment)
            }

        }, 3000)
        return binding!!.root
    }

    private val isFinished: Int
        get() {
            val sharedPref = activity?.getSharedPreferences("asd", Context.MODE_PRIVATE)
            return sharedPref!!.getInt(Shared.ON_BOARDING.name, 0)
        }

}