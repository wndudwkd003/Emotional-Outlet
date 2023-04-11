package com.zynar.emotional_outlet.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zynar.emotional_outlet.helpers.ServerConnectionHelper
import com.zynar.emotional_outlet.helpers.enums.Server
import okhttp3.Call
import okhttp3.Response

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }


    private val _postList = MutableLiveData<List<Post>>().apply {
        value = ArrayList()
    }

    fun setPostList(postList: List<Post>) {
        _postList.postValue(postList)
    }


    val postList: LiveData<List<Post>> = _postList

    val text: LiveData<String> = _text
}