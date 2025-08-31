package com.example.task_manager_api.controller;

import com.example.task_manager_api.entity.Task;
import com.example.task_manager_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

//    create task
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

//    get all tasks
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

//    get task by id
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

//    update task by id
    @PutMapping("/{id}")
    public Task updateTaskById(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

//    delete task by id
    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
