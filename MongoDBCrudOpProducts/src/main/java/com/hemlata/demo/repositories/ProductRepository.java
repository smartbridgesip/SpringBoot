package com.hemlata.demo.repositories;


import org.springframework.data.repository.CrudRepository;

import com.hemlata.demo.domain.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
}
