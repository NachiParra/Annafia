package com.example.annafia.src.item

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ListView
import androidx.lifecycle.Observer
import com.example.annafia.R
import com.example.annafia.db.medicine.AppDatabase
import com.example.annafia.db.medicine.Medicine
import com.example.annafia.db.medicine.MedicineAdapter

class ListItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_items)

        val listItems = findViewById<ListView>(R.id.items_list)
        var listDataItems = emptyList<Medicine>()
        val database = AppDatabase.getDatabase(this)

        database.medicines().getAll().observe(this, Observer {
            listDataItems = it
            val adapter = MedicineAdapter(this, listDataItems)
            listItems.adapter = adapter
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.add_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_item -> {
                val intent = Intent(this, NewOrEditActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }


}