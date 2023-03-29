package com.eradiux.orderservice.service;


import com.eradiux.orderservice.dto.InventoryResponse;
import com.eradiux.orderservice.dto.OrderLineItemsDto;
import com.eradiux.orderservice.dto.OrderRequest;
import com.eradiux.orderservice.model.Order;
import com.eradiux.orderservice.model.OrderLineItems;
import com.eradiux.orderservice.repository.OrderRepository;
import com.eradiux.orderservice.utils.MapToResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl extends MapToResponseDto implements OrderService {
private final OrderRepository orderRepository;
private final WebClient webClient;



    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();

        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);
        List<String> skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();

        System.out.println(skuCodes);

        //Call Inventory Service and place order is product is ibn stock

        InventoryResponse[] inventoryResponseArray = webClient.get().uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes
                ).build()).retrieve()
        .bodyToMono(InventoryResponse[].class)
        .block();

        System.out.println(Arrays.toString(inventoryResponseArray));

        assert inventoryResponseArray != null;
        boolean allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(
                inventoryResponse -> inventoryResponse.isInStock);


        if(allProductsInStock){
            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("Product is not in stock, please try again latter");
        }
    }


}
