package com.zynar.emotional_outlet.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zynar.emotional_outlet.databinding.FragmentHomeBinding
import com.zynar.emotional_outlet.helpers.ServerConnectionHelper
import com.zynar.emotional_outlet.ui.home.write.PostWriteActivity
import okhttp3.Call
import okhttp3.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val serverHelper = ServerConnectionHelper("/post/upload")
        serverHelper.setClientCallBackListener(object : ServerConnectionHelper.ClientCallBackListener {
            override fun onResponse(call: Call, response: Response) {
               Log.d("my_emotion", response.body?.string() ?: "실패")
            }

        })


        // 글 쓰기
        binding.fabPostWrite.setOnClickListener {
            val intent = Intent(requireContext(), PostWriteActivity::class.java)
            startActivity(intent)
        }


        //val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}