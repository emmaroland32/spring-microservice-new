package com.eradiux.productservice.utils;

import com.eradiux.productservice.dto.ProductResponse;
import com.eradiux.productservice.model.Product;

public class MapToResponseDto {
    public ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
