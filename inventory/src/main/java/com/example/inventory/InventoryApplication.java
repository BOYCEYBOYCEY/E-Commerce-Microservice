package com.example.inventory;


import com.example.inventory.model.Inventory;
import com.example.inventory.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class InventoryApplication {


	public static void main(String[] args) {

		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){

		return args -> {

//			Inventory inventory=new Inventory();
//			inventory.setSkuCode("iphone13");
//			inventory.setQuantity(100);
//
//			Inventory inventory1=new Inventory();
//			inventory1.setSkuCode("iphone14");
//			inventory1.setQuantity(200);

//			Inventory inventory3=new Inventory();
//			inventory3.setSkuCode("iphone13_red");
//			inventory3.setQuantity(0);

//			inventoryRepository.save(inventory3);
//			inventoryRepository.save(inventory);
//			inventoryRepository.save(inventory1);






		};


	}




}
