package com.example.machine_test.service;


import com.example.machine_test.dto.ProductDTO;
import com.example.machine_test.entity.Product;
import com.example.machine_test.mapper.ProductMapper;
import com.example.machine_test.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public List<ProductDTO> getAllProducts() {

        List<ProductDTO> products = productRepository.findAll()
                .stream()
                .map( productMapper::toDTO)
                .toList();

        return products;
    }

    @Override
    public List<ProductDTO> getProductByTag(String tag) {
        log.info("getProductByTag method got called with tag : {}", tag);
        List<ProductDTO> products = productRepository.findAllByTags(tag)
                .stream()
                .map( productMapper::toDTO)
                .toList();

        return products;
    }
}
