package threading;

import dao.ProductDAO;

public class CustomerThread extends Thread {
    private ProductDAO productDAO;

    // Constructor to pass the productDAO object
    public CustomerThread(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    // The 'run' method will contain the actions the customer will perform
    @Override
    public void run() {
        System.out.println("Customer is browsing products...");

        try {
            // Wait for 3 seconds to allow the admin to add products first
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fetch and print all products in the store
        productDAO.getAllProducts().forEach(product -> 
            System.out.println("Customer sees: " + product));
    }
}
