package com.eradiux.productservice.service;

import com.eradiux.productservice.dto.ProductRequest;
import com.eradiux.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProduct();
}
