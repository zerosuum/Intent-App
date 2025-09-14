package com.example.intentapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StudentProfile(
    var name: String = "Della Nurizki",
    var nim: String = "221234567",
    var program: String = "Teknologi Rekayasa Perangkat Lunak",
    var semester: String = "3 (Ganjil 24/25)",
    var gpa: String = "3.80",
    var hobby: String = "Ngoding, memasak, baca novel",
    var quote: String = "Practice yourself, for heaven's sake, in little things; and thence proceed to greater",
    var email: String = "delaaaanr@gmail.com",
    var website: String = "https://della.dev"
) : Parcelable