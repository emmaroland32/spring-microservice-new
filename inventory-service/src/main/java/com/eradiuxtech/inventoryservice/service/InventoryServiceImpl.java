package com.eradiuxtech.inventoryservice.service;


import com.eradiuxtech.inventoryservice.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService{
    private InventoryRepository inventoryRepository;


    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
     return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
