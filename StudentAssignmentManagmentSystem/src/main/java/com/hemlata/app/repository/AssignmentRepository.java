package com.hemlata.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hemlata.app.model.Assignment;
import com.hemlata.app.model.Instructor;

public interface AssignmentRepository extends CrudRepository<Assignment,Long> {



}
