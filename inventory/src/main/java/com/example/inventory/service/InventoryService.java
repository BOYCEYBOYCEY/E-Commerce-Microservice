package com.example.inventory.service;

import com.example.inventory.dto.InventoryResponse;
import com.example.inventory.repository.InventoryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
@Slf4j
public class InventoryService {

   private final InventoryRepository inventoryRepository;

   @Transactional(readOnly = true)
   public List<InventoryResponse> isInStock(List<String> skuCode) throws InterruptedException {

       log.info("wait started");
       Thread.sleep(10000);
       log.info("wait ended");

       return inventoryRepository.findBySkuCodeIn(skuCode).stream()
               .map(inventory->
                   InventoryResponse.builder().skuCode(inventory.getSkuCode())
                           .isInStock(inventory.getQuantity()>0)
                           .build()
               ).toList();

   }




}
