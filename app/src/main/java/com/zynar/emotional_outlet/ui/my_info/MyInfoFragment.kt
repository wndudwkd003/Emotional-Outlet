package com.zynar.emotional_outlet.ui.my_info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zynar.emotional_outlet.R

class MyInfoFragment : Fragment() {

    companion object {
        fun newInstance() = MyInfoFragment()
    }

    private lateinit var viewModel: MyInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}