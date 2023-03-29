package com.eradiux.orderservice.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    private String skuCode;
    public Boolean isInStock;

}
