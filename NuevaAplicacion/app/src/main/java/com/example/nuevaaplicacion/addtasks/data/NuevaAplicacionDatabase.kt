package com.example.nuevaaplicacion.addtasks.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity:: class], version = 1)
abstract class NuevaAplicacionDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}