package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PROFILE = "EXTRA_PROFILE"
    }

    private lateinit var binding: ActivityMainBinding

    // state awal
    private var studentProfile = StudentProfile(
        name = "Della Nurizki",
        nim = "221234567",
        program = "Teknologi Rekayasa Perangkat Lunak",
        semester = "3 (Ganjil 24/25)",
        gpa = "3.80",
        hobby = "Ngoding, memasak, baca novel",
        quote = "Stay hungry, stay foolish.",
        email = "delaaaanr@gmail.com",
        website = "https://della.dev"
    )

    // launcher untuk EditActivity
    private val editLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { res ->
        if (res.resultCode == RESULT_OK && res.data != null) {
            res.data!!.getParcelableExtra<StudentProfile>(EXTRA_PROFILE)?.let {
                studentProfile = it
                showProfile()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showProfile()

        binding.btnDetail.setOnClickListener {
            val i = Intent(this, DetailActivity::class.java)
            i.putExtra(EXTRA_PROFILE, studentProfile)
            startActivity(i)
        }

        binding.btnEdit.setOnClickListener {
            val i = Intent(this, EditActivity::class.java)
            i.putExtra(EXTRA_PROFILE, studentProfile)
            editLauncher.launch(i)
        }
    }

    private fun showProfile() = with(binding) {
        tvName.text = studentProfile.name
        tvNim.text = studentProfile.nim
        // tvQuote.text = studentProfile.quote
    }
}
