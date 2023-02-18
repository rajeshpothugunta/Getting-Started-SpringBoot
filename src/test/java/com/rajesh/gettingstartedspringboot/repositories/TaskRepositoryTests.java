package com.rajesh.gettingstartedspringboot.repositories;

import com.rajesh.gettingstartedspringboot.taskapiV2WithDB.entities.TaskEntity;
import com.rajesh.gettingstartedspringboot.taskapiV2WithDB.repository.TasksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
public class TaskRepositoryTests {
    @Autowired
    private TasksRepository taskRepository;

    @Test
    public void testTaskRepository() {
        TaskEntity task = new TaskEntity();
        task.setTitle("Test Task");
        task.setDescription("Test Description");
        task.setCompleted(false);
        task.setDueDate(new Date());
        var savedTask = taskRepository.save(task);
        assertNotNull(savedTask);
    }

    @Test
    public void readTasksWorks() {
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("Test Task");
        task1.setDescription("Test Description");
        task1.setCompleted(false);
        TaskEntity task2 = new TaskEntity();
        task2.setTitle("Test Task 2");
        task2.setDescription("Test Description 2");
        task2.setCompleted(false);
        taskRepository.save(task1);
        taskRepository.save(task2);
        var tasks = taskRepository.findAll();
        assertNotNull(tasks);
        assertEquals(2, tasks.size());
    }

    @Test
    public void findByCompletedWorks() {
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("Test Task");
        task1.setDescription("Test Description");
        task1.setCompleted(false);
        TaskEntity task2 = new TaskEntity();
        task2.setTitle("Test Task 2");
        task2.setDescription("Test Description 2");
        task2.setCompleted(true);
        taskRepository.save(task1);
        taskRepository.save(task2);
        var completedTasks = taskRepository.findAllByCompleted(true);
        var incompleteTasks = taskRepository.findAllByCompleted(false);

        assertEquals(1, completedTasks.size());
        assertEquals(1, incompleteTasks.size());

    }
}
