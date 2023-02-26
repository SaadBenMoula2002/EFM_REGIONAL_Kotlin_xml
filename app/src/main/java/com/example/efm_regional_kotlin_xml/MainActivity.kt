package com.example.efm_regional_kotlin_xml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private lateinit var emptyOrBlankTextView: TextView
    private lateinit var acronymTextView: TextView
    private lateinit var checkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.input_edit_text)
        emptyOrBlankTextView = findViewById(R.id.empty_or_blank_text_view)
        acronymTextView = findViewById(R.id.acronym_text_view)
        checkButton = findViewById(R.id.check_button)

        checkButton.setOnClickListener {
            val inputText = inputEditText.text.toString()
            emptyOrBlankTextView.text = if (inputText.estVideOuBlanche()) "Vide" else "Blanche"
            acronymTextView.text = inputText.sigle()
        }
    }

    fun String.estVideOuBlanche(): Boolean {
        val regex = Regex("^\\s*\$")
        var result = false
        if (this.isEmpty()) {
            result = true
        } else if (regex.matches(this)) {
            result = false
        }
        return result
    }


    fun String.sigle(): String {
        val words = this.split("\\s+".toRegex())
        return words.joinToString(separator = "") { it.first().toUpperCase().toString() }
    }

}


