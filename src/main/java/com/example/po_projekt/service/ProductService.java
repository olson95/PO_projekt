package com.example.po_projekt.service;

import com.example.po_projekt.entity.Product;
import com.example.po_projekt.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    private static long nextId = 1;

    public ProductService() {
    }

    private boolean isEmpty() {
        return productRepository.count() == 0;
    }

    public List<Product> getProductList(String keyword) {
        if (keyword != null) {
            return productRepository.findProductsWithSubstring(keyword);
        }
//        if (category != null){
//            return productRepository.findProductsByCategory(category);
//        }
        return productRepository.findAll();
    }




    public void addProduct(Product product, MultipartFile file) {
        try {
            product.setImageData(file.getBytes());
            productRepository.save(product);
        } catch (Exception e) {
            log.debug("Some internal error occurred", e);
        }
    }

//        productRepository.save(product);
//    }

    public Product getProductById(long id) {
        var value = productRepository.findById(id);
        return value.isEmpty() ? null : value.get();
    }

    public Optional<Product> findById(Long imageId) {
        return productRepository.findById(imageId);
    }



    public Product getProduct(Product product) {
        return getProductById(product.getId());
    }

    public void updateProduct(Product product, Integer id) {
        Product prod = getProductById(id);
        prod.setName(product.getName());
        prod.setCategory(product.getCategory());
        prod.setPrice(product.getPrice());
        prod.setProducer(product.getProducer());
        prod.setDescription(product.getDescription());
        prod.setQuantity(product.getQuantity());
        productRepository.save(prod);
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