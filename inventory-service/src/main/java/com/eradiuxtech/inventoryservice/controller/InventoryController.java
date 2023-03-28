package com.eradiuxtech.inventoryservice.controller;


import com.eradiuxtech.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean IsInStock(@PathVariable("sku-code") String skuCode){
        return inventoryService.isInStock(skuCode);

    }
}
