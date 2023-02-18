package com.rajesh.gettingstartedspringboot.taskapiV2WithDB.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity(name = "tasks")
@Getter
@Setter
public class TaskEntity extends BaseEntity{
    @Column(name = "title",nullable = false,length = 50)
    private String title;
    @Column(name = "description",nullable = true,length = 300)
    private String description;
    @Column(name = "due_date",nullable = true)
    private Date dueDate;
    @Column(name = "completed",nullable = false,columnDefinition = "boolean default false")
    private Boolean completed;
    @OneToMany(mappedBy = "task",fetch = FetchType.LAZY)
    private List<NoteEntity> notes;

}
