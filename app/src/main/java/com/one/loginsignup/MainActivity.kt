package com.one.loginsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button1)
        val btn1 =findViewById<Button>(R.id.button2)
        btn.setOnClickListener {

            val i = Intent(this,LoginActivity::class.java)
            startActivity(i)
        }
        btn1.setOnClickListener {
            val i = Intent(this,SignUpActivity::class.java)
            startActivity(i)
        }
    }
}