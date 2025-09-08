package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(receiver = binding) {
            btnToSecondActivity.setOnClickListener {
                // navigate to second activity with intent

                val intentToSecondAcitvity = Intent(this@MainActivity, SecondActivity::class.java)
                intentToSecondAcitvity.putExtra("name", "della")
                startActivity(intentToSecondAcitvity)
            }
        }
    }
}