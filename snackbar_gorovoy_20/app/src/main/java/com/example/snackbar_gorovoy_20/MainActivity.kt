package com.example.snackbar_gorovoy_20

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.snackbar_gorovoy_20.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var coordinatorLayout: CoordinatorLayout
    private var button3_clicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coordinatorLayout = findViewById(R.id.coordinatorLayout)

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        button1.setOnClickListener { view ->
            Snackbar.make(coordinatorLayout, "Была нажата 1 кнопка", Snackbar.LENGTH_SHORT).show()
        }

        button2.setOnClickListener { view ->
            val snackbar = Snackbar.make(coordinatorLayout, "Вы что-то изменили", Snackbar.LENGTH_LONG)
            button2.text = "Snackbar"
            snackbar.setAction("Вернуть как было?") {
                button2.text = "Snackbar с кнопкой"
                Snackbar.make(coordinatorLayout,"Все вернулось на свои места!",Snackbar.LENGTH_LONG).show()
            }
            snackbar.show()
        }

        button3.setOnClickListener { view ->
            if (!button3_clicked) {
                button3_clicked = true
                Snackbar.make(coordinatorLayout, "Нажата 3 кнопка", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Повторить") {
                        button3_clicked = false
                    }
                    .show()
            } else {
                val snackbar = Snackbar.make(coordinatorLayout, "Повторите ещё раз", Snackbar.LENGTH_INDEFINITE)
                snackbar.setAction("Повторить") {
                    snackbar.dismiss()
                    Snackbar.make(coordinatorLayout, "Нажата 3 кнопка", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Повторить") {
                            button3_clicked = false
                        }
                        .show()
                }
                snackbar.show()
            }
        }

        fab.setOnClickListener{view ->
            val snackbar = Snackbar.make(coordinatorLayout, "Вы нажали на FloatingActionButton",Snackbar.LENGTH_SHORT).show()
        }
    }
}