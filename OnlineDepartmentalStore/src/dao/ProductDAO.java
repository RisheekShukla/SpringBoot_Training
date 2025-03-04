package dao;

import java.util.*;
import pojo.Product;

public class ProductDAO {
	
	private Map<Integer, Product> productMap;

    public ProductDAO() {
        productMap = new HashMap<>();
    }

    // Insert product into the store
    public void addProduct(Product product) {
        productMap.put(product.getProductid(), product);
    }

    // Fetch all products
    public List<Product> getAllProducts() {
        return productMap.values().stream().toList();
    }

    // Search product by ID
    public Product getProductById(int productId) {
        return productMap.get(productId);
    }

    // Update product
    public void updateProduct(Product product) {
        if(productMap.containsKey(product.getProductid())) {
            productMap.put(product.getProductid(), product);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Remove product
    public void deleteProduct(int productId) {
        productMap.remove(productId);
    }
}
