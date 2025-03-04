package threading;

import dao.ProductDAO;
import pojo.Product;

public class AdminThread extends Thread {
    private ProductDAO productDAO;

    // Constructor to pass the productDAO object
    public AdminThread(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    // The 'run' method will contain the actions the admin will perform
    @Override
    public void run() {
        System.out.println("Admin is adding products...");
        
        // Simulate the admin adding 5 products, one after the other
        for (int i = 1; i <= 5; i++) {
            productDAO.addProduct(new Product(i, "Product" + i, i * 100, 100));
            System.out.println("Admin added: Product" + i);
            try {
                // Pause for 1 second after adding each product
                Thread.sleep(1000); // Simulate the time taken to add a product
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
