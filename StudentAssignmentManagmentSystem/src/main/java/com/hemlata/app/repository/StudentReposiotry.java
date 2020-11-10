package com.hemlata.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hemlata.app.model.Instructor;
import com.hemlata.app.model.Student;


@Repository
	public interface StudentReposiotry extends CrudRepository<Student, Long>{
	Student findByEmailIdIgnoreCase(String EmailId);
}
