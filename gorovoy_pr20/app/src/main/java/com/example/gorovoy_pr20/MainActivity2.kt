package com.example.gorovoy_pr20

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

    }

    fun onClick(view: View) {
        val snackbar = Snackbar.make(view,"Вы нажали кнопку", Snackbar.LENGTH_LONG)
        snackbar.setAction("Next...", View.OnClickListener() {
            snackbar.setActionTextColor(Color.BLUE);
        }).show()


    }
}