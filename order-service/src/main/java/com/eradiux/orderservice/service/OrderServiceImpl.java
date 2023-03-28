package com.eradiux.orderservice.service;


import com.eradiux.orderservice.dto.OrderLineItemsDto;
import com.eradiux.orderservice.dto.OrderRequest;
import com.eradiux.orderservice.model.Order;
import com.eradiux.orderservice.model.OrderLineItems;
import com.eradiux.orderservice.repository.OrderRepository;
import com.eradiux.orderservice.utils.MapToResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl extends MapToResponseDto implements OrderService {
private final OrderRepository orderRepository;



    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();

        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);

        //Call Inventory Service and place order is product is ibn stock

        orderRepository.save(order);
    }


}
