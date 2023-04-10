package com.zynar.emotional_outlet.ui.title

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
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

        setFullScreen(requireActivity())    // 상태바 숨김 - 전체 화면

        val handler = Handler()
        handler.postDelayed({
            val navController = Navigation.findNavController(binding!!.root)
            clearFullScreen(requireActivity())    // 전체 화면 해제

            if (isFinished() == 1) {
                navController.navigate(R.id.titleFragment)
            } else {
                navController.navigate(R.id.onBoardingFragment)
            }

        }, 3000)

        return binding!!.root
    }

    private fun isFinished(): Int {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        return sharedPref!!.getInt(Shared.ON_BOARDING.name, 0)
    }

    private fun setFullScreen(activity: Activity) {
        if (Build.VERSION.SDK_INT < 30) {
            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        } else if (Build.VERSION.SDK_INT >= 30) {
            // 30 버전 이후 다시 만들것
        }

    }

    private fun clearFullScreen(activity: Activity) {
        activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}