package com.example.nuevaaplicacion.addtasks.domain

import com.example.nuevaaplicacion.addtasks.data.TaskRepository
import com.example.nuevaaplicacion.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(
    private val taskRepository: TaskRepository) {
    operator  fun invoke():Flow<List<TaskModel>> = taskRepository.tasks

}
