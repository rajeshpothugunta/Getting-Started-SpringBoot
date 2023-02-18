package com.rajesh.gettingstartedspringboot.taskapi.services.exceptions;

public class TaskNotFoundException extends IllegalArgumentException{
    public TaskNotFoundException(Integer id) {
        super("Task with id " + id + " not found");
    }
}
