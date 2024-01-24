package com.example.po_projekt.repository;

import com.example.po_projekt.entity.Category;
import com.example.po_projekt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query("SELECT p FROM Product p WHERE p.category.name = :category")
//    List<Product> findProductsByCategory(@RequestParam("category") String category);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%" +
            "OR p.category.name LIKE %?1%" +
            "OR p.producer LIKE %?1%")
    List<Product> findProductsWithSubstring(String keyword);

}
