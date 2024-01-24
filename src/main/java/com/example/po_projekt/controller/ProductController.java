package com.example.po_projekt.controller;

import com.example.po_projekt.entity.Category;
import com.example.po_projekt.entity.Product;
import com.example.po_projekt.service.CategoryService;
import com.example.po_projekt.service.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Controller
@Slf4j
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/shop")
    public String shopPage(Model model, @Param("keyword") String keyword){
        List<Product> productList = productService.getProductList(keyword);
        model.addAttribute("productList", productList);
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("keyword", keyword);
        return "/shop";
    }

    @GetMapping("/offer")
    public String home(Model model){
        List<Product> productList = productService.getProductList(null);
        model.addAttribute("productList", productList);
        return "/offer";
    }

    @GetMapping("/home")
    public String homePage(Model model){
        List<Product> productList = productService.getProductList(null);
        model.addAttribute("productList", productList);
        return "/";
    }

    @GetMapping("/addProduct")
    public String add(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getCategories());
        return "/addProduct";
    }

//    @PostMapping("/addProduct")
//    public String add(@ModelAttribute Product product){
//        productService.addProduct(product);
//        return "redirect:/offer";
//    }
@PostMapping(value = "/addProduct", consumes = MULTIPART_FORM_DATA_VALUE)
public String handleProfileAdd(Product product, @RequestPart("file") MultipartFile file) {

    log.info("handling request parts: {}", file);
    productService.addProduct(product, file);
    return "redirect:/offer";
}

    @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource downloadImage(@PathVariable Long imageId) {
        byte[] image = productService.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getImageData();

        return (Resource) new ByteArrayResource(image);
    }

    @GetMapping("/details")
    public String add(@RequestParam("id") long inputId, Model model) {
        model.addAttribute("product", productService.getProductById(inputId));
        return "/sproduct";
    }

    @GetMapping(value = {"/{prodId}/editProduct"})
    public String edit(Model model, @PathVariable Integer prodId){
        model.addAttribute("product", productService.getProductById(prodId));
        model.addAttribute("categories", categoryService.getCategories());
        return "/editProduct";
    }

    @PostMapping(value = {"{prodId}/editProduct"})
    public String edit(@ModelAttribute Product product, @PathVariable Integer prodId) {
        productService.updateProduct(product, prodId);
//        System.out.println(product.getId());
        return "redirect:/offer";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("id") long id) {
        productService.deleteProductById(id);
        return "redirect:/offer";
    }



    }



