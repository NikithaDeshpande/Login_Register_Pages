package com.example.myapplication1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        val emailLayout: TextInputLayout = findViewById(R.id.textInputLayout)
        val email: TextInputEditText = emailLayout.findViewById(R.id.et_email)
        val passwordLayout: TextInputLayout = findViewById(R.id.textInputLayout2)
        val password: TextInputEditText = passwordLayout.findViewById(R.id.et_password)
        val t1: TextView = findViewById(R.id.textView)
        Log.d("MainActivity","onCreate() method finished")
        t1.setOnClickListener {
            val enteredEmail = email.text.toString()
            val enteredPassword = password.text.toString()
            viewModel.email = enteredEmail
            viewModel.password = enteredPassword

            val toastMessage = "Entered Email: $enteredEmail\nEntered Password: $enteredPassword"
            Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_LONG).show()
        }
        val t: TextView = findViewById(R.id.textView6)
        t.setOnClickListener {
            val i = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(i)
        }
    }
}