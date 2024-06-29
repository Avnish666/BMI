package com.model.bmi

import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        val intent = intent

        val weight = intent.getFloatExtra("weight", 0.0f)
        val height = intent.getFloatExtra("height", 0.0f)
        val heightm = height / 100
        val bmi = weight / (heightm * heightm)
        val bmifinal= findViewById<TextView>(R.id.bmif)
        bmifinal.text="BMI : $bmi"
        val progressbar=findViewById<ProgressBar>(R.id.progressbar)
        progressbar.max=4000
        val currentProgress=(bmi*100).toInt()
        ObjectAnimator.ofInt(progressbar,"progress",currentProgress)
            .setDuration(2000)
            .start()
        val review=findViewById<TextView>(R.id.review)
        if(bmi<=18.5)
            review.text="You are considered Underweight"
        else if(bmi<25)
            review.text="You are considered Healthy"
        else if(bmi<30)
            review.text="You are considered Overweight"
        else
            review.text="You are considered Obese"
    }
}
