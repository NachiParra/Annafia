package com.example.annafia.db.medicine

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "medicines")
class Medicine(
    val name: String,
    val description: String,
    val presentation1: String,
    val presentation2: String,
    val presentation3: String,
    val presentation4: String,
    val presentation5: String,
    @PrimaryKey(autoGenerate = true)
    var idMedicine: Int = 0
): Serializable {
}