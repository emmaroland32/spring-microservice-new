package com.eradiux.productservice.service;

import com.eradiux.productservice.dto.ProductRequest;
import com.eradiux.productservice.dto.ProductResponse;
import com.eradiux.productservice.model.Product;
import com.eradiux.productservice.repository.ProductRepository;
import com.eradiux.productservice.utils.MapToResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl extends MapToResponseDto implements ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder().name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());


    }

    public List<ProductResponse> getAllProduct() {

        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();

    }


}
