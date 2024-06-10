package com.example.myapplication.st10438072.practicum

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.compose.ui.res.fontResource
import com.example.myapplication.st10438072.practicum.databinding.DetailedViewActivityBinding
import java.util.ArrayList

class MainScreen : AppCompatActivity() {

    private val dates = ArrayList<String>()
    private val morningScreenTimes = ArrayList<Int>()
    private val afternoonScreenTimes = ArrayList<Int>()
    private val activityNotes = ArrayList<String>()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val dateEditText = findViewById<EditText>(R.id.DateEditText)
        val morningScreenTimeEditText = findViewById<EditText>(R.id.MorningScreenTimeEditText)
        val afternoonScreenTimeTextEdit = findViewById<EditText>(R.id.AfternoonScreenTimeEditText)
        val actvityNotesEditText= findViewById<EditText>(R.id.ActivityNotesEditText)
        val addButton = findViewById<Button>(R.id.AddButton)
        val clearButton = findViewById<Button>(R.id.ClearStoredDataButton)
        val viewDetailsButton = findViewById<Button>(R.id.ViewDetailsButton)

        addButton.setOnClickListener {
            val date = dateEditText.text.toString()
            val morningScreenTime = morningScreenTimeEditText.text.toString().toIntOrNull()
            val afternoonScreenTime = afternoonScreenTimeTextEdit.text.toString().toIntOrNull()
            val activityNote = actvityNotesEditText.text.toString()


            if (date.isNotEmpty() && morningScreenTime !=null && afternoonScreenTime !=null && activityNote.isNotEmpty()){
                dates.add(date)
                morningScreenTimes.add(morningScreenTime)
                afternoonScreenTimes.add(afternoonScreenTime)
                activityNotes.add(activityNote)
                Toast.makeText(this,"Data Added",Toast.LENGTH_SHORT).show()
                clearFields(dateEditText,morningScreenTimeEditText,afternoonScreenTimeTextEdit,actvityNotesEditText)
            }else{
                Toast.makeText(this,"Please fill in all fields", Toast.LENGTH_SHORT).show()
            }

        }
        clearButton.setOnClickListener {
            //  dates.clear()
            //  morningScreenTimes.clear()
            //  afternoonScreenTimes.clear()
            //  activityNotes.clear()
            //  Toast.makeText(this, "Data Cleared", Toast.LENGTH_SHORT).show()
            clearFields(dateEditText,morningScreenTimeEditText,afternoonScreenTimeTextEdit,actvityNotesEditText)
        }
        viewDetailsButton.setOnClickListener {
            val intent = Intent(this, DetailedViewActivityBinding::class.java)
            intent.putStringArrayListExtra("dates",dates)
            intent.putIntegerArrayListExtra("morningScreenTimes",morningScreenTimes)
            intent.putIntegerArrayListExtra("afternoonScreenTimes",afternoonScreenTimes)
            intent.putStringArrayListExtra("activityNotes",activityNotes)
            startActivity(intent)
        }
    }
    private fun clearFields(vararg fields: EditText){
        for (field in fields){
            field.text.clear()
        }
    }
}





