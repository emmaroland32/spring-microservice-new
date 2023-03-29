package com.eradiuxtech.inventoryservice.controller;


import com.eradiuxtech.inventoryservice.dto.InventoryResponse;
import com.eradiuxtech.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;


    //http://localhost:8082/api/inventory?sku-code=iphone-13&sku-code=iphone-13-red
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> IsInStock(@RequestParam List<String> skuCodes){
        return inventoryService.isInStock(skuCodes);

    }
}
