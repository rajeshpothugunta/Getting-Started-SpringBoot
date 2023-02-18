package com.rajesh.gettingstartedspringboot.taskapiV2WithDB.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "notes")
public class NoteEntity extends BaseEntity {
    @Column(name = "body",nullable = false,length = 500)
    private String body;

    @ManyToOne
    private TaskEntity task;
}
