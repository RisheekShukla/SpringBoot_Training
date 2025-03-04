package service;

import dao.ProductDAO;
import dao.UserDAO;
import pojo.Product;
import pojo.User;

import java.util.List;

public class AdminService {
    private ProductDAO productDAO;
    private UserDAO userDAO;

    public AdminService() {
        productDAO = new ProductDAO();
        userDAO = new UserDAO();
    }

    // Add a new product
    public void addProduct(Product product) {
        productDAO.addProduct(product);
        System.out.println("Product added: " + product.getpname());
    }

    // List all products
    public List<Product> listAllProducts() {
        return productDAO.getAllProducts();
    }

    // Search for a product by ID
    public Product searchProductById(int productId) {
        Product product = productDAO.getProductById(productId);
        if (product != null) {
            return product;
        } else {
            System.out.println("Product not found with ID: " + productId);
            return null;
        }
    }

    // List products by category
//    public List<Product> listProductsByCategory(String category) {
//        // Implement category-based filtering in ProductDAO if needed
//        return productDAO.getAllProducts().stream()
//            .filter(product -> product.getCategory().equals(category))
//            .toList();
//    }

    // Update product details
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    // Delete a product
    public void deleteProduct(int productId) {
        productDAO.deleteProduct(productId);
        System.out.println("Product with ID " + productId + " deleted.");
    }

    // List all users
    public List<User> listAllUsers() {
        return userDAO.getAllUsers();
    }

    // Add a new user (admin-level access)
    public void addUser(User user) {
        userDAO.addUser(user);
        System.out.println("User added: " + user.getUsername());
    }

    // Delete a user by username
    public void deleteUser(String username) {
        userDAO.deleteUser(username);
    }

    // Update user details
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}
