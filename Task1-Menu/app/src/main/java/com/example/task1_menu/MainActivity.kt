package com.example.task1_menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Next (view : View){

        var intent: Intent = Intent(this , MainActivity2::class.java)
        startActivity(intent)
        finish()

    }
}