package com.odyssey.notes

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logo);

        logo.setOnClickListener {
            Toast.makeText(
                this,
                "¡Click!",
                Toast.LENGTH_SHORT).show()

            val i = Intent(this, AuthActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}