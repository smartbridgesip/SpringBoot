package com.hemlata.app.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hemlata.app.model.Document;
import com.hemlata.app.model.DocumentSubmit;


@Repository
public interface subRepo2 extends JpaRepository<DocumentSubmit,Long> {
/*@Query("select Id,NAme,size from Document")
List<Document> findAll();*/
	@Query(value="select CURDATE()",nativeQuery=true)
	public Date getCurDate();
}
