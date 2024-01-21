package com.example.po_projekt.controller;

import com.example.po_projekt.entity.Product;
import com.example.po_projekt.service.CategoryService;
import com.example.po_projekt.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/offer")
    public String home(Model model){
        List<Product> productList = productService.getProductList();
        model.addAttribute("productList", productList);
        return"/employee/offer";
    }

    @GetMapping("/addProduct")
    public String add(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getCategories());
        return "/employee/addProduct";
    }

    @PostMapping("/addProduct")
    public String add(@ModelAttribute Product product){
        productService.addProduct(product);
        return "redirect:/offer";
    }

    @GetMapping(value = {"/{prodId}/editProduct"})
    public String edit(Model model, @PathVariable Integer prodId){
        model.addAttribute("product", productService.getProductById(prodId));
        model.addAttribute("categories", categoryService.getCategories());
        return "/employee/editProduct";
    }

    @PostMapping(value = {"/editProduct"})
    public String edit(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/offer";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("id") long id) {
        productService.deleteProductById(id);
        return "redirect:/offer";
    }
}
