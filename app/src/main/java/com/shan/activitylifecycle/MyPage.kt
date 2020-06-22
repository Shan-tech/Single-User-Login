package com.shan.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MyPage : AppCompatActivity() {

    lateinit var txtHelloWorld:TextView
    lateinit var txtName:TextView
    lateinit var imgDark:ImageView
    lateinit var etEnterSomething:EditText
    lateinit var btnClick:Button
    var text=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_relative_layout)
        title="Info"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        txtHelloWorld=findViewById(R.id.textHelloWorld)
        txtName=findViewById(R.id.txtName)
        imgDark=findViewById(R.id.imgDark)
        etEnterSomething=findViewById(R.id.etEnterSmthig)
        btnClick=findViewById(R.id.btnClick)

       val name= intent.getStringExtra("name")
        findViewById<TextView>(R.id.txtName).text= "Hii $name"

        btnClick.setOnClickListener{
            val intent=Intent(this@MyPage,MessageActivity::class.java)
            intent.putExtra("text",etEnterSomething.text.toString())
            startActivity(intent)
        }
    }
}
