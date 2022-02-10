package com.example.annafia.db.medicine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.annafia.R

class MedicineAdapter(private val mediContext: Context, private val mediList: List<Medicine>): ArrayAdapter<Medicine>(mediContext, 0, mediList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mediContext).inflate(R.layout.item_list, parent, false)

        val data = mediList[position]

        val name = layout.findViewById<TextView>(R.id.item_name)
        val description = layout.findViewById<TextView>(R.id.item_description)

        name.text = data.name
        description.text = data.description

        return super.getView(position, convertView, parent)
    }
}