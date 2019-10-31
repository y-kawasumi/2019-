package com.example.myapplication

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import com.example.myapplication.ShareData as ShareData

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textbutton.isEnabled = (this.application as ShareData).ButtonEnable

        setting_button.setOnClickListener {
            val intent = Intent(applicationContext, setting::class.java)
            startActivity(intent)

        }

        textbutton.setOnClickListener{
            output_text.setTextColor((this.application as ShareData).ColorCode)
            output_text.text = message.text
        }
    }
    fun Refresh(){
        textbutton.isEnabled = (this.application as ShareData).ButtonEnable
    }
}
