package com.example.machine_test.mapper;

import com.example.machine_test.dto.ProductDTO;
import com.example.machine_test.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductDTO productDTO) {

        if (productDTO == null)
            return null;

        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setTags(productDTO.getTags());
        return product;

    }

    public ProductDTO toDTO(Product product) {

        if (product == null)
            return null;

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(product.getProductName());
        productDTO.setTags(product.getTags());
        productDTO.setDescription(productDTO.getDescription());
        return productDTO;

    }
}
