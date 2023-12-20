package com.example.myapplication1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication1.databinding.ActivityMain2Binding
import com.google.gson.Gson

class RegisterActivity : AppCompatActivity() {
    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        binding.viewModel=registerViewModel
        val button: TextView = findViewById(R.id.button)
        button.setOnClickListener {
            val m =
                "${registerViewModel.name}  ${registerViewModel.phone}  ${registerViewModel.email} ${registerViewModel.password}"
            Toast.makeText(applicationContext, m, Toast.LENGTH_LONG).show()
        }
        val t: TextView = findViewById(R.id.tv_medium_text)
        t.setOnClickListener {
            val i = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(i)
        }


        val gson=Gson()
        val obj=DataStorage("Tony","nikithad712@gmail.com","89765432","1234567")
        val message:String=gson.toJson(obj)
        Log.d("MainActivity",message)

        val message1="{\"email \":\"nikithad712@gmail.com\",\"name\":\"Tony\",\"password\":\"1234567\",\"phone\":\"89765432\"}"
        val obj1:DataStorage=gson.fromJson(message1, DataStorage::class.java)
        Log.d("MainActivity2",obj1.toString())
    }
}