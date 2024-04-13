package co.edu.escuelaing.cvds.lab7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.escuelaing.cvds.lab7.model.Category;
import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.service.ProductService;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String getProducts(Model model){
        List<Product> products = productService.getProducts();
        model.addAttribute("list", products);
        return "products";
    }

    @GetMapping("/new")
    public String getNewProduct(){
        return "create";
    }

    @PostMapping("/new/confirm")
    public String createProduct(@RequestParam Integer id, String name, String description, String category, Integer price, Integer quantity){
        productService.createProduct(id,  name, description, category,  price, quantity);
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String updateProduct(Model model, Integer ProductId){
        model.addAttribute("ProductId",ProductId);
        return "update";
    }

    @PostMapping("/update/confirm")
    public String updateProduct(@RequestParam Integer id, String name, String description, String category, Integer price, Integer quantity){
        productService.updateProduct(id,  name, description, category,  price, quantity);
        return "redirect:/products";
    }

    @PostMapping("/delete/confirm")
    public String deleteProduct(@RequestParam Integer productId){
        productService.deleteProduct(productId);
        return "redirect:/products";
    }

    
}