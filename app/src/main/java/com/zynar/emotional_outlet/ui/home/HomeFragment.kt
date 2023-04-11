package com.zynar.emotional_outlet.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zynar.emotional_outlet.databinding.FragmentHomeBinding
import com.zynar.emotional_outlet.helpers.ServerConnectionHelper
import com.zynar.emotional_outlet.helpers.adapters.RecyclerViewPostPreviewAdapter
import com.zynar.emotional_outlet.helpers.enums.Server
import com.zynar.emotional_outlet.ui.home.write.PostWriteActivity
import okhttp3.Call
import okhttp3.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // 글쓰기 버튼
        binding.fabPostWrite.setOnClickListener {
            val intent = Intent(requireContext(), PostWriteActivity::class.java)
            startActivity(intent)
        }

        val data = HashMap<String, String>()
        data["uid"] = "test_uid"

        val server = ServerConnectionHelper(Server.DOMAIN_VIEW_POST, data)
        server.setClientCallBackListener(object : ServerConnectionHelper.ClientCallBackListener {
            override fun onResponse(call: Call, response: Response) {
                val json = response.body!!.string()
                Log.d("__emo", json)
                val post = Gson().fromJson<List<Post>>(json, object : TypeToken<List<Post>>(){}.type)
                homeViewModel.setPostList(post)
            }
        })



        // 게시글 리사이클러뷰
        val rvAdapter = RecyclerViewPostPreviewAdapter(requireContext())
        binding.rvPostPreview.setHasFixedSize(true)
        binding.rvPostPreview.adapter = rvAdapter

        homeViewModel.postList.observe(viewLifecycleOwner) {
            rvAdapter.setItem(it)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}