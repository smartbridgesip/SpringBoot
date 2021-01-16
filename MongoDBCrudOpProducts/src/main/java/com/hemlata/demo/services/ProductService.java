package com.hemlata.demo.services;


import java.util.List;

import com.hemlata.demo.commands.ProductForm;
import com.hemlata.demo.domain.Product;


public interface ProductService {

    List<Product> listAll();

    Product getById(String id);

    Product saveOrUpdate(Product product);

    void delete(String id);

    Product saveOrUpdateProductForm(ProductForm productForm);
}
