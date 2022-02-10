package com.example.annafia.src

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.lifecycle.Observer
import com.example.annafia.R
import com.example.annafia.db.medicine.AppDatabase
import com.example.annafia.db.medicine.Medicine
import com.example.annafia.db.medicine.MedicineAdapter
import kotlinx.coroutines.channels.ProducerScope

class ListHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_home)

        val homeList = findViewById<ListView>(R.id.list_home)
        val database = AppDatabase.getDatabase(this)
        var datalist = emptyList<Medicine>()

        database.medicines().getAll().observe(this, Observer{
            datalist = it
            val adapter = MedicineAdapter(this, datalist)
            homeList.adapter = adapter
        })

        homeList.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, FormulaDosisNuevaActivity::class.java )
            intent.putExtra("medicine", datalist[i])
            startActivity(intent)
        }


    }
}