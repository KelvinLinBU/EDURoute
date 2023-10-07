package com.example.simple_calculator_app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity

class FloorPlan : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floor_plan)
        val pic_button = findViewById<ImageButton>(R.id.pic_button);
        pic_button.setOnClickListener {

                var correct_toast = Toast.makeText(this,"Zooming In!" , Toast.LENGTH_SHORT)
                correct_toast.show()
                val m_app = Intent(this, innerinner::class.java)
                startActivity(m_app)
            }
        }



    }
