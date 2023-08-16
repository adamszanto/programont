package com.example.projectmongo.repository;

import com.example.projectmongo.repository.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends MongoRepository<ProductEntity, String> {

}