package com.example.mypdf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var selectPdfBTN: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inIt()

        selectPdfBTN.setOnClickListener {
            val intent = Intent(this@MainActivity,ViewPdfActivity::class.java)
            startActivity(intent)
        }
    }

    private fun inIt(){
        selectPdfBTN = findViewById(R.id.selectPdfBTN)
    }
}