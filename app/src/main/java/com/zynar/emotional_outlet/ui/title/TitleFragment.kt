package com.zynar.emotional_outlet.ui.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zynar.emotional_outlet.R
import com.zynar.emotional_outlet.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    var binding : FragmentTitleBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentTitleBinding.inflate(inflater, container, false)
        return binding!!.root

    }
}