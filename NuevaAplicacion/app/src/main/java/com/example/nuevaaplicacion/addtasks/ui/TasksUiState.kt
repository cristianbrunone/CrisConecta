package com.example.nuevaaplicacion.addtasks.ui

import com.example.nuevaaplicacion.addtasks.ui.model.TaskModel

sealed  interface TasksUiState {
     object Loading: TasksUiState
     data class  Error (val throwable: Throwable)
     data class Success(val tasks:List <TaskModel>) : TasksUiState
}