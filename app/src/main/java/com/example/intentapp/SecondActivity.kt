package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentapp.databinding.ActivityMainBinding
import com.example.intentapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    private var launcher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        val data = result.data

        val address = data?.getStringExtra("address")
        binding.txtAddress.text = "Alamat: $address"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(binding.root)
        // terima extra str param dr intent pertama / main act

        var name = intent.getStringExtra("name")

        with(receiver = binding) {
            txtName.text = "Welcome, ${name}!"
            txtAddress.text = "Address: -"

            btnToThirdActivity.setOnClickListener {
                val intenToInputAddress = Intent(this@SecondActivity, ThirdActivity::class.java)
                launcher.launch(intenToInputAddress)
            }
        }
    }
}