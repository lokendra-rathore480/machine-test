package com.example.machine_test.service;

import com.example.machine_test.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    List<ProductDTO> getProductByTag(String tag);
}
