package com.example.doctorapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        val text = "Find your doctor"
        val spannableString = SpannableString(text)
        val foregroundColorSpanCyan = ForegroundColorSpan(Color.GRAY)

        spannableString.setSpan(foregroundColorSpanCyan, 4, 16,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannableString


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = listOf("dr. Gilang Segara Bening", "dr. Shabil Chan", "dr. Mustakim", "dr. Suprihatini", "dr. Suprihatini", "dr. Gilang Segara Bening", "dr. Shabil Chan", "dr. Mustakim", "dr. Suprihatini", "dr. Suprihatini") // Replace with your actual data
        val images = listOf(R.drawable.doc1_profile, R.drawable.doc2_profile, R.drawable.doc3_profile, R.drawable.doc3_profile, R.drawable.doc3_profile, R.drawable.doc1_profile, R.drawable.doc2_profile, R.drawable.doc3_profile, R.drawable.doc3_profile, R.drawable.doc3_profile) // Replace with your actual image resources

        val adapter = MyAdapter(data, images) { selectedItem ->
            val selectedIndex = data.indexOf(selectedItem)
            val selectedImage = images[selectedIndex]

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("selectedItem", selectedItem)
            intent.putExtra("selectedImage", selectedImage)
            startActivity(intent)
        }



        recyclerView.adapter = adapter

    }
}