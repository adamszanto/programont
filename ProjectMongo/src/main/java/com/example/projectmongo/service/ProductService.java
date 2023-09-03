package com.example.projectmongo.service;

import com.example.projectmongo.repository.mongodb.ProductRepository;
import com.example.projectmongo.repository.entity.ProductEntity;
import com.example.projectmongo.service.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
//    private final ElasticsearchMotor elasticsearchMotor;
    private final ModelMapper modelMapper;

//    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
//        this.productRepository = productRepository;
//        this.modelMapper = modelMapper;
//    }
// TODO: RequiredArgs Lombok?
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
//        this.elasticsearchMotor = elasticsearchMotor;
        this.modelMapper = modelMapper;
    }

    public Product addProduct(Product product) {
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        ProductEntity savedEntity = productRepository.save(productEntity);
        return modelMapper.map(savedEntity, Product.class);
    }

//    public Product addProductToElasticsearch(Product product) {
//        ProductEntity productentity = modelMapper.map(product, ProductEntity.class);
//        ProductEntity savedEntity = elasticsearchMotor.save(productentity);
//        return modelMapper.map(savedEntity, Product.class);
//    }

    public List<Product> getAllProduct() {
        List<ProductEntity> result = productRepository.findAll();
        return result.stream()
                .map(product -> modelMapper.map(product, Product.class))
                .collect(Collectors.toList());
    }

    public Product getProductById(String productId) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product with id " + productId + " not found."));

                return modelMapper.map(product, Product.class);
    }

//    public List<Product> searchProductByName(String name) {
//        List<ProductEntity> result = elasticsearchMotor.findAllByName(name);
//
//        return result.stream()
//                .map(product -> modelMapper.map(product, Product.class))
//                .collect(Collectors.toList());
//    }

    public void deleteProductById(String productId) {
        if(!productRepository.existsById(productId)) {
            throw new NoSuchElementException("Product with id " + productId + " not found.");
        }
        productRepository.deleteById(productId);
    }

    public Product updateProduct(String productId, Product updatedProduct) {
        ProductEntity current = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product with id " + productId + " not found."));

        current.setName(updatedProduct.getName());
        current.setModelNumber(updatedProduct.getModelNumber());
        current.setBrand(updatedProduct.getBrand());
        current.setUrl(updatedProduct.getUrl());
        current.setImage(updatedProduct.getImage());
        current.setPrice(updatedProduct.getPrice());

        ProductEntity updated = productRepository.save(current);
        return modelMapper.map(updated, Product.class);
    }
}
