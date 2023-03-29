package com.eradiuxtech.inventoryservice.service;

import com.eradiuxtech.inventoryservice.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    List<InventoryResponse> isInStock(List<String> skuCodes);
}
