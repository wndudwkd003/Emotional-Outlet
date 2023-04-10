package com.zynar.emotional_outlet.ui.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zynar.emotional_outlet.helpers.adapters.FragmentPagerAdapter
import java.util.*
import com.zynar.emotional_outlet.databinding.FragmentOnBoardingBinding as FragmentOnBoardingBinding


class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        val fragmentList = Arrays.asList(
            OnBoarding1Fragment(),
            OnBoarding2Fragment(),
            OnBoarding3Fragment()
        )

        val adapter = FragmentPagerAdapter(requireActivity(), fragmentList)
        binding.viewPager2.adapter = adapter

        return binding.root
    }

}