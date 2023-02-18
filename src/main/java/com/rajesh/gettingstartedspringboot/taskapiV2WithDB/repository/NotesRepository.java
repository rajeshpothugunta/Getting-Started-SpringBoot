package com.rajesh.gettingstartedspringboot.taskapiV2WithDB.repository;

import com.rajesh.gettingstartedspringboot.taskapiV2WithDB.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<NoteEntity, Integer> {
}
