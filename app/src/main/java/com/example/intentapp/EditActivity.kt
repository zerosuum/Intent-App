package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    private lateinit var current: StudentProfile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        current = intent.getParcelableExtra(MainActivity.EXTRA_PROFILE) ?: StudentProfile()
        prefill(current)

        binding.btnSave.setOnClickListener {
            val updated = current.copy(
                name     = binding.etName.text?.toString()?.trim().orEmpty(),
                nim      = binding.etNim.text?.toString()?.trim().orEmpty(),
                program  = binding.etProgram.text?.toString()?.trim().orEmpty(),
                semester = binding.etSemester.text?.toString()?.trim().orEmpty(),
                gpa      = binding.etGpa.text?.toString()?.trim().orEmpty(),
                hobby    = binding.etHobby.text?.toString()?.trim().orEmpty(),
                quote    = binding.etQuote.text?.toString()?.trim().orEmpty(),
                email    = binding.etEmail.text?.toString()?.trim().orEmpty(),
                website  = binding.etWebsite.text?.toString()?.trim().orEmpty()
            )
            setResult(RESULT_OK, Intent().putExtra(MainActivity.EXTRA_PROFILE, updated))
            finish()
        }
    }

    private fun prefill(p: StudentProfile) = with(binding) {
        etName.setText(p.name)
        etNim.setText(p.nim)
        etProgram.setText(p.program)
        etSemester.setText(p.semester)
        etGpa.setText(p.gpa)
        etHobby.setText(p.hobby)
        etQuote.setText(p.quote)
        etEmail.setText(p.email)
        etWebsite.setText(p.website)
    }
}
