package com.hemlata.app.repository;
import com.hemlata.app.model.Categories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Categories, Integer>{

}
