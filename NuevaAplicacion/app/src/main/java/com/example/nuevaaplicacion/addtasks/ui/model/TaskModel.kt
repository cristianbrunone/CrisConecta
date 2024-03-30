package com.example.nuevaaplicacion.addtasks.ui.model

data class TaskModel(val id: Int = System.currentTimeMillis().hashCode(), val task: String, var selected: Boolean = false)
