package com.shan.activitylifecycle

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MessageActivity : AppCompatActivity() {
    lateinit var txtdiscreption:TextView
    lateinit var txttext:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        title="Info"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        txtdiscreption=findViewById(R.id.txtdiscription)
        txttext=findViewById(R.id.txttext)

        val text = intent.getStringExtra("text")
        val result=findViewById<TextView>(R.id.txttext)
        result.text=text
    }
}
