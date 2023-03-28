package com.eradiux.orderservice.utils;

import com.eradiux.orderservice.dto.OrderLineItemsDto;
import com.eradiux.orderservice.model.OrderLineItems;

public class MapToResponseDto {

    public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return  orderLineItems;
    }
}
