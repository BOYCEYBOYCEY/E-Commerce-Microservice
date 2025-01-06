package com.example.inventory.controller;


import com.example.inventory.dto.InventoryResponse;
import com.example.inventory.service.InventoryService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Data
public class InventoryController {


    private final InventoryService inventoryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) throws InterruptedException {


        return inventoryService.isInStock(skuCode);


    }


}
