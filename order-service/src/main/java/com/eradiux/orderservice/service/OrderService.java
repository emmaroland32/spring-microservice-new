package com.eradiux.orderservice.service;

import com.eradiux.orderservice.dto.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
