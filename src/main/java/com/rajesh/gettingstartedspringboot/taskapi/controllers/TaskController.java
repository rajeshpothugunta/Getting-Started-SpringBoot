package com.rajesh.gettingstartedspringboot.taskapi.controllers;

import com.rajesh.gettingstartedspringboot.taskapi.dtos.ErrorResponse;
import com.rajesh.gettingstartedspringboot.taskapi.entities.Task;
import com.rajesh.gettingstartedspringboot.taskapi.services.TaskService;
import com.rajesh.gettingstartedspringboot.taskapi.services.exceptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private TaskService taskService;

    public TaskController() {
        this.taskService = new TaskService();
    }


    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Integer id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @PatchMapping("/tasks/{id}/{title}")
    public Task updateTaskTitle(@PathVariable Integer id, @PathVariable String title) {
        return taskService.updateTaskTitle(id, title);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    ResponseEntity<ErrorResponse>  handleErrors(TaskNotFoundException ex) {
        var errorResponse = new ErrorResponse(ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
