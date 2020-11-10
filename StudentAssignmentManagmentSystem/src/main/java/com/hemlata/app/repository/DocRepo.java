package com.hemlata.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hemlata.app.model.Document;


@Repository
public interface DocRepo extends JpaRepository<Document,Long> {

	@Modifying(clearAutomatically = true) 
	@Transactional
	@Query(value="UPDATE Document SET Status=:status WHERE Id=:id",nativeQuery=true)
	public void updateStatus(long id,String status);
	

}
