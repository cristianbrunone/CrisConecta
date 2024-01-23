package com.example.nuevaaplicacion.addtasks.ui.model

data class TaskModel(val id: Long = System.currentTimeMillis(), val task: String, var selected: Boolean = false)
