package com.example.annafia.src.item

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.annafia.R
import com.example.annafia.db.medicine.AppDatabase
import com.example.annafia.db.medicine.Medicine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewOrEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_or_edit)

        val name = findViewById<TextView>(R.id.editTextTextPersonName)
        val description = findViewById<TextView>(R.id.editTextTextPersonName2)
        val pre1 = findViewById<TextView>(R.id.editTextTextPersonName3)
        val pre2 = findViewById<TextView>(R.id.editTextTextPersonName4)
        val pre3 = findViewById<TextView>(R.id.editTextTextPersonName5)
        val pre4 = findViewById<TextView>(R.id.editTextTextPersonName6)
        val pre5  = findViewById<TextView>(R.id.editTextTextPersonName7)

        val database = AppDatabase.getDatabase(this)
        val saveBtn = findViewById<Button>(R.id.button2)

        saveBtn.setOnClickListener {
            val btnName = name.text.toString()
            val btnDescription = description.text.toString()
            val btnPre1 = pre1.text.toString()
            val btnPre2 = pre2.text.toString()
            val btnPre3 = pre3.text.toString()
            val btnPre4 = pre4.text.toString()
            val btnPre5 = pre5.text.toString()

            val medicine = Medicine(btnName,
                btnDescription,
                btnPre1,
                btnPre2,
                btnPre3,
                btnPre4,
                btnPre5)

            CoroutineScope(Dispatchers.IO).launch {
                database.medicines().insertAll(medicine)
                this@NewOrEditActivity.finish()
            }

        }


    }
}