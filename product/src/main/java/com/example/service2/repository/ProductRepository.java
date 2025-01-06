package com.example.service2.repository;

import com.example.service2.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String > {
}
