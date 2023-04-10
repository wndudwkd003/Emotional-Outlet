package com.zynar.emotional_outlet.ui.title

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Api
import com.google.android.gms.common.api.ApiException
import com.zynar.emotional_outlet.MainActivity
import com.zynar.emotional_outlet.R
import com.zynar.emotional_outlet.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding : FragmentTitleBinding = FragmentTitleBinding.inflate(inflater, container, false)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val client = GoogleSignIn.getClient(requireActivity(), gso)

        binding.btnGoogleSignIn.setOnClickListener {
            onLogin(client)
        }

        return binding.root
    }

    private fun onLogin(client: GoogleSignInClient) {
        val signInIntent: Intent = client.signInIntent
        startActivityForResult(signInIntent, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("EMOTION", resultCode.toString() + "이거")
        when(requestCode) {
            1000 -> {
                try {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                    val account = task.result!!

                    val intent = Intent(requireActivity(), MainActivity::class.java)
                    requireActivity().startActivity(intent)

                    Log.d("PASS", account.email ?: "")

                    requireActivity().finish()

                } catch (e: ApiException) {
                    e.printStackTrace()
                }
            }
        }
    }
}