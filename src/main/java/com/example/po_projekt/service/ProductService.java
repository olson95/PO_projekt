package com.example.po_projekt.service;

import com.example.po_projekt.entity.Product;
import com.example.po_projekt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    private static long nextId = 1;

    public ProductService() {
    }

    private boolean isEmpty() {
        return productRepository.count() == 0;
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
//        validateProduct(product);
        product.setId(nextId);
        productRepository.save(product);
        nextId++;
    }

    public Product getProductById(long id) {
        var value = productRepository.findById(id);
        return value.isEmpty() ? null : value.get();
    }

    public Product getProduct(Product product) {
        return getProductById(product.getId());
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }


    private void checkIfGreaterThanZero(double number, String name) {
        if (number <= 0) {
            throw new IllegalArgumentException(name + " must be greater than 0!");
        }
    }

    public void deleteProduct(Product product) {
        productRepository.deleteById(product.getId());
    }

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }
}