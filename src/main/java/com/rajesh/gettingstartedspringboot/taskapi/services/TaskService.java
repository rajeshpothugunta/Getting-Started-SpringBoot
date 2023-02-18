package com.rajesh.gettingstartedspringboot.taskapi.services;

import com.rajesh.gettingstartedspringboot.taskapi.entities.Task;
import com.rajesh.gettingstartedspringboot.taskapi.services.exceptions.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {
    private Integer taskId = 1;
    private final ArrayList<Task> taskList = new ArrayList<>();

    public TaskService() {
        taskList.add(new Task(taskId++, "Learn Spring Boot", "Learn Spring Boot in 10 minutes", new Date()));
        taskList.add(new Task(taskId++, "Learn Spring MVC", "Learn Spring MVC in 10 minutes", new Date()));
        taskList.add(new Task(taskId++, "Learn Spring", "Learn Spring in 10 minutes", new Date()));
    }

    public ArrayList<Task> getAllTasks() {
        return taskList;
    }

    public Task addTask(Task task) {
        var newTask = new Task(taskId++, task.getTitle(), task.getDescription(), task.getDueDate());
        taskList.add(newTask);
        return newTask;
    }

    public Task getTaskById(Integer id) {
        return taskList.stream().filter(task -> task.getId().equals(id)).findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task updateTask(Integer id, Task task) {
        var taskToUpdate = getTaskById(id);
        if(taskToUpdate == null){
            throw new TaskNotFoundException(id);
        }
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setDueDate(task.getDueDate());
        return taskToUpdate;
    }

    public Task updateTaskTitle(Integer id, String title) {
        var taskToUpdate = getTaskById(id);
        if(taskToUpdate == null){
            throw new TaskNotFoundException(id);
        }
        taskToUpdate.setTitle(title);
        return taskToUpdate;
    }

    public void deleteTask(Integer id) {
        var taskToDelete = getTaskById(id);
        if(taskToDelete == null){
            throw new TaskNotFoundException(id);
        }
        taskList.remove(taskToDelete);
    }
}
