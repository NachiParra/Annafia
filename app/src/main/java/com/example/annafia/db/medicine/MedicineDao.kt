package com.example.annafia.db.medicine

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface MedicineDao {

    @Query("SELECT * FROM medicines")
    fun getAll(): LiveData<List<Medicine>>

    @Query("SELECT * FROM medicines WHERE idMedicine = :id")
    fun get(id: Int): LiveData<Medicine>

    @Insert
    fun insertAll(vararg medicine: Medicine)

    @Update
    fun update(medicine: Medicine)

}