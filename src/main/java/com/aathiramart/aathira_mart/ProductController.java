package com.aathiramart.aathira_mart;

import com.aathiramart.aathira_mart.entity.Product;
import com.aathiramart.aathira_mart.repository.ProductRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String productsPage(Model model) {

        List<Product> products = productRepository.findAll();

        model.addAttribute("products", products);

        return "products";
    }
}