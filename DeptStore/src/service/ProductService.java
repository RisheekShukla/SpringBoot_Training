package service;

import dao.ProductDAO;
import pojo.Product;

import java.util.List;

public class ProductService {

    private ProductDAO productDAO;

    public ProductService() {
        productDAO = new ProductDAO();
    }

    // Add a new product
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    // List all products
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    // Find product by ID
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    // Delete product by ID
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }

    // Other business logic like calculating selling prices, validating product data, etc.
    public void calculateSellingPrice(Product product) {
        double buyingPrice = product.getsp();
        double sellingPrice = (buyingPrice * 0.5) + buyingPrice;
        product.setsp(sellingPrice);
    }
}
