package com.example.dynamoDB.service;




import com.example.dynamoDB.model.Product;
import com.example.dynamoDB.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductRepo productRepository;

    public ProductService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    // Create Product
    public String createProduct(Product product) {
        return productRepository.createProduct(product);
    }

    // Get Product by ID
    public Product getProductById(String id) {
        return productRepository.getProductById(id);
    }

    // Update Product by ID
    public Product updateProduct(String id, Product product) {
        return productRepository.updateProduct(id, product);
    }

    // Delete Product by ID
    public String deleteProduct(String id) {
        return productRepository.deleteProduct(id);
    }
}
