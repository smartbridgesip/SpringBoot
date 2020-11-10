package com.hemlata.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hemlata.app.model.Instructor;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Long> {
	Instructor findByEmailIdIgnoreCase(String EmailId);
}
