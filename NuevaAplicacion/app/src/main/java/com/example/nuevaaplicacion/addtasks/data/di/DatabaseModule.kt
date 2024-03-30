package com.example.nuevaaplicacion.addtasks.data.di

import android.content.Context
import androidx.room.Room
import com.example.nuevaaplicacion.addtasks.data.NuevaAplicacionDatabase
import com.example.nuevaaplicacion.addtasks.data.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideTaskDao(nuevaAplicacionDatabase: NuevaAplicacionDatabase): TaskDao {
        return nuevaAplicacionDatabase.taskDao()
    }

    @Provides
    @Singleton
    fun provideNuevaAplicacionDatabase(@ApplicationContext appContext: Context):  NuevaAplicacionDatabase{
        return Room.databaseBuilder(appContext, NuevaAplicacionDatabase:: class.java, "TaskDatabase").build()
    }
}