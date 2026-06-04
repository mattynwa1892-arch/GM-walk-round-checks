package com.gmwalkaround.inspection.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gmwalkaround.inspection.R
import com.gmwalkaround.inspection.MainActivity
import com.gmwalkaround.inspection.data.models.Inspection
import kotlinx.coroutines.launch

class InspectionActivity : AppCompatActivity() {

    private lateinit var titleInput: EditText
    private lateinit var descriptionInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inspection)

        titleInput = findViewById(R.id.titleInput)
        descriptionInput = findViewById(R.id.descriptionInput)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            saveInspection()
        }

        findViewById<Button>(R.id.backButton).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun saveInspection() {
        val title = titleInput.text.toString()
        val description = descriptionInput.text.toString()

        if (title.isNotEmpty()) {
            lifecycleScope.launch {
                startActivity(Intent(this@InspectionActivity, MainActivity::class.java))
                finish()
            }
        }
    }
}
