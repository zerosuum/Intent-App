package com.example.intentapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val p = intent.getParcelableExtra<StudentProfile>(MainActivity.EXTRA_PROFILE) ?: StudentProfile()

        with(binding) {
            tvName.text     = p.name
            tvNim.text      = p.nim
            tvProgram.text  = p.program
            tvSemester.text = p.semester
            tvGpa.text      = p.gpa
            tvHobby.text    = p.hobby
            tvQuote.text    = p.quote
            tvEmail.text    = p.email
            tvWebsite.text  = p.website
        }
    }
}
