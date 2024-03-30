package com.example.nuevaaplicacion.addtasks.domain

import com.example.nuevaaplicacion.addtasks.data.TaskRepository
import com.example.nuevaaplicacion.addtasks.ui.model.TaskModel
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(taskModel: TaskModel){
        taskRepository.update(taskModel)
    }
}
