package com.example.dynamoDB.repo;



import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import com.example.dynamoDB.model.Product;

import org.springframework.stereotype.Repository;

@Repository

public class ProductRepo {

    public DynamoDBMapper dynamoDBMapper;

    public ProductRepo(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    // Create Product
    public String createProduct(Product product) {
        dynamoDBMapper.save(product);
        return product.getProductId();
    }

    // Get Product by ID
    public Product getProductById(String id) {
        return dynamoDBMapper.load(Product.class, id);
    }

    // Update Product by ID
    public Product updateProduct(String id, Product product) {
        Product load = dynamoDBMapper.load(Product.class, id);
        if (load != null) {
            // Map the fields from the passed product object to the loaded product
            load.setName(product.getName());
            load.setPrice(product.getPrice());
            load.setDescription(product.getDescription());
            load.setCategory(product.getCategory());
            load.setStockQuantity(product.getStockQuantity());

            // Save the updated product
            dynamoDBMapper.save(load);
            return dynamoDBMapper.load(Product.class, id);  // Return the updated product
        }
        return null;  // Return null if product not found
    }

    // Delete Product by ID
    public String deleteProduct(String id) {
        Product load = dynamoDBMapper.load(Product.class, id);
        if (load != null) {
            dynamoDBMapper.delete(load);
            return load.getProductId() + " was deleted!";
        }
        return "Product not found!";
    }
}
