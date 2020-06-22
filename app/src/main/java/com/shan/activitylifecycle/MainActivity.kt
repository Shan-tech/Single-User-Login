package com.shan.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shan.activitylifecycle.R.*

class MainActivity : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var btnContinue: Button
    lateinit var etpassword: EditText
    var validEmail="Admin"
    var validPassword="123456"
    lateinit var sharedPreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(string.shared_preferance), Context.MODE_PRIVATE)
        val login=sharedPreferences.getBoolean("login",false)
        if (login){
            val i = Intent(this@MainActivity, MyPage::class.java)
            i.putExtra("name",validEmail)
            startActivity(i)
        }
        else{
            setContentView(layout.google)
        }
        btnContinue = findViewById(id.btnContinue)
        etEmail = findViewById(id.etEmail)
        etpassword = findViewById(id.etPasword)
        btnContinue.setOnClickListener {
            sharedPreference()
        }
    }
    override fun onPause() {
            super.onPause()
            finish()
        }
     fun sharedPreference() {
         val email = etEmail.text.toString().trim()
         val password = etpassword.text.toString().trim()
         when{
             email.isEmpty()->{
                 Toast.makeText(this@MainActivity, "Username can't be empty", Toast.LENGTH_SHORT).show()
             }
             password.isEmpty()->{
                 Toast.makeText(this@MainActivity, "Password can't be empty", Toast.LENGTH_SHORT).show()
             }
         }
           if (email == validEmail && password == validPassword) {
               sharedPreferences.edit().putBoolean("login", true).apply()
               val go =Intent(this@MainActivity, MyPage::class.java)
               go.putExtra("name",validEmail)
               startActivity(go)
           }
           else {
               Toast.makeText(this@MainActivity, "Enter valid credentials", Toast.LENGTH_LONG)
                   .show() }
       }

     }






