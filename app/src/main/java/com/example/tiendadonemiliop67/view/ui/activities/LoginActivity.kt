package com.example.tiendadonemiliop67.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiendadonemiliop67.R
import com.example.tiendadonemiliop67.databinding.ActivityLoginBinding
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.auth.api.Auth
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    val AUTH_REQUEST_CODE=1234
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var listener:FirebaseAuth.AuthStateListener
    lateinit var providers: List<AuthUI.IdpConfig>

    override fun onStart() {
        super.onStart()
        firebaseAuth.addAuthStateListener (listener)
    }

    override fun onStop() {
        if (listener !=null)
            firebaseAuth.removeAuthStateListener(listener)
        super.onStop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        providers= arrayListOf(
                AuthUI.IdpConfig.EmailBuilder().build(),
               // AuthUI.IdpConfig.GoogleBuilder().build(),
               // AuthUI.IdpConfig.PhoneBuilder().build(),
               // AuthUI.IdpConfig.AnonymousBuilder().build(),
        )
        val intent = Intent(this, MainActivity::class.java)
        firebaseAuth= FirebaseAuth.getInstance()
        listener= FirebaseAuth.AuthStateListener { q1 ->
            val user= q1.currentUser
            if (user!=null){
                startActivity(intent)

            }else{
                startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .setLogo(R.drawable.logo_vertical)
                    .setTheme(R.style.LoginTheme)
                    .build(),AUTH_REQUEST_CODE)
            }
        }
    }
}