package com.example.doctorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val selectedItem = intent.getStringExtra("selectedItem")
        val selectedImage = intent.getIntExtra("selectedImage", 0)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        imageView.setImageResource(selectedImage)
        textView.text = selectedItem
    }
}