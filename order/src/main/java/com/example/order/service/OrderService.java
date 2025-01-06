package com.example.order.service;


import com.example.order.dto.InventoryResponse;
import com.example.order.dto.OrderLineItemDto;
import com.example.order.dto.OrderRequest;
import com.example.order.model.Orders;
import com.example.order.model.OrderLineItem;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service

public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public OrderService(OrderRepository orderRepository, WebClient.Builder webClientBuilder) {
        this.orderRepository = orderRepository;
        this.webClientBuilder = webClientBuilder;

    }

    public String placeOrderService(OrderRequest orderRequest){

        List<OrderLineItem> orderLineItemList=orderRequest.getOrderLineItemDtoList()
                .stream().map(this::mapToOrderLineItem).toList();


        List<String> skuCodes= orderRequest.getOrderLineItemDtoList().stream()
                           .map(OrderLineItemDto::getSkuCode)
                           .toList();


        Orders order=Orders.builder()
                .orderNumber(UUID.randomUUID().toString())
                .OrderLineItemList(orderLineItemList)
                .build();


         InventoryResponse[] inventoryResponseArray= webClientBuilder.build().get()
                .uri("http://inventory/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();


        boolean allProductsInStock= Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::getIsInStock);




       if(allProductsInStock){
           orderRepository.save(order);
           return "Order Placed Successfully";
       }else{
           throw  new IllegalArgumentException("Product is not in stock, please try again later");
       }




    }

    private OrderLineItem mapToOrderLineItem(OrderLineItemDto orderLineItemDto) {


        return OrderLineItem.builder()
                .skuCode(orderLineItemDto.getSkuCode())
                .price(orderLineItemDto.getPrice())
                .Quantity(orderLineItemDto.getQuantity())
                .build();

    }


}
