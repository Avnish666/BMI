package com.model.bmi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
          val weight=findViewById<EditText>(R.id.weight)
          val height=findViewById<EditText>(R.id.height)
          val btnsub=findViewById<Button>(R.id.btnsub)
        btnsub.setOnClickListener {

            val weight:Float=weight.text.toString().toFloat()
            val height:Float=height.text.toString().toFloat()
            val intent=Intent(this,ResultActivity::class.java)
            intent.putExtra("weight",weight)
            intent.putExtra("height",height)
            startActivity(intent)
        }
    }
}