package com.example.task_manager_api.service;

import com.example.task_manager_api.entity.Task;
import com.example.task_manager_api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


    //    create task
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

//    get all tasks
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

//    get task by id
    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

//    update task by id
    public Task updateTask(Long id, Task updatedTask){
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null){
            task.setName(updatedTask.getName());
            task.setDescription(updatedTask.getDescription());
            return taskRepository.save(task);
        }
        return null;
    }

//    delete task by id
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
