package com.rajesh.gettingstartedspringboot.taskapiV2WithDB.repository;

import com.rajesh.gettingstartedspringboot.taskapiV2WithDB.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TasksRepository extends JpaRepository<TaskEntity, Integer> {
    List<TaskEntity> findAllByCompleted(boolean completed);
    // Ideally this is 'business logic' terminology (i.e. 'overdue') so shouldn't be here
    @Query("SELECT t from tasks t where t.completed = false and t.dueDate < CURRENT_DATE")
    List<TaskEntity> findAllOverdue();
    List<TaskEntity> findAllByCompletedAndDueDateBefore(boolean completed, Date dueDate);

    List<TaskEntity> findAllByTitleContainingIgnoreCase(String titleFragment);
}
