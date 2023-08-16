package com.example.projectmongo.service;

import com.example.projectmongo.repository.ProductRepository;
import com.example.projectmongo.repository.SearchMotor;
import com.example.projectmongo.repository.entity.ProductEntity;
import com.example.projectmongo.service.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final SearchMotor searchMotor;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, SearchMotor searchMotor, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.searchMotor = searchMotor;
        this.modelMapper = modelMapper;
    }

    public Product addProduct(Product product) {
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        ProductEntity savedEntity = productRepository.save(productEntity);
        return modelMapper.map(savedEntity, Product.class);
    }

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

    public List<Product> searchProductByName(String name) {
        List<ProductEntity> result = searchMotor.findAllByName(name);

        return result.stream()
                .map(product -> modelMapper.map(product, Product.class))
                .collect(Collectors.toList());

    }
}
