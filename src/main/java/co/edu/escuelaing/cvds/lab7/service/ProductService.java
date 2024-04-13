package co.edu.escuelaing.cvds.lab7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.cvds.lab7.model.Category;
import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(Integer id, String name, String description, String role, Integer price, Integer quantity){
        Product newProduct = new Product(id, name, description, role, price, quantity);
        productRepository.save(newProduct);
    }

    public void updateProduct(Integer id, String name, String description, String role, Integer price, Integer quantity){
        Product product;
        Optional<Product> optionalProduct = productRepository.findById(id);
        
        if(optionalProduct.isPresent()){
            product = optionalProduct.get();
            product.setId(id);
            product.setName(name);
            product.setDescription(description);
            product.setCategory(role);
            product.setPrice(price);
            product.setQuantity(quantity);;
            productRepository.save(product);
        }

    }

    public void deleteProduct(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(id);
        }
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

}
