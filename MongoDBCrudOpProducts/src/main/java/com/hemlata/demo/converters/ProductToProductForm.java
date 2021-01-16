package com.hemlata.demo.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hemlata.demo.commands.ProductForm;
import com.hemlata.demo.domain.Product;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId().toHexString());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setImageUrl(product.getImageUrl());
        return productForm;
    }
}
