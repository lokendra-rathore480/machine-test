package com.example.machine_test.controller;

import com.example.machine_test.dto.ProductDTO;
import com.example.machine_test.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getProductByTag(@RequestParam String tag){
        return ResponseEntity.ok(productService.getProductByTag(tag));
    }
}
