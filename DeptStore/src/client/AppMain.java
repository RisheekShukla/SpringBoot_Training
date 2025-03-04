package client;

import dao.ItemDAO;
import dao.ProductDAO;
import dao.UserDAO;
import pojo.Item;
import pojo.Product;
import pojo.User;
import threading.AdminThread;
import threading.CustomerThread;

import java.util.List;
import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {
    	ProductDAO productDAO = new ProductDAO();

        Thread admin = new AdminThread(productDAO);
        Thread customer = new CustomerThread(productDAO);

        admin.start();
        customer.start();
        ItemDAO itemDAO = new ItemDAO();
        UserDAO userDAO = new UserDAO();
        
//        prepopulateData(itemDAO, productDAO, userDAO);
        
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Departmental Store System!");
        
        while (!exit) {
            System.out.println("\nSelect a role:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    adminActions(sc, itemDAO, productDAO, userDAO);
                    break;
                case 2:
                    customerActions(sc, productDAO, userDAO);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        sc.close();
        System.out.println("Thank you for using the Departmental Store System.");
    	 
    }

    // Admin actions (managing items, products, and users)
    private static void adminActions(Scanner sc, ItemDAO itemDAO, ProductDAO productDAO, UserDAO userDAO) {
        boolean exitAdmin = false;
        
        while (!exitAdmin) {
            System.out.println("\nAdmin Panel:");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Add Item to Category");
            System.out.println("4. View Items by Category");
            System.out.println("5. Manage Users");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int prodId = sc.nextInt();
                    System.out.print("Enter product name: ");
                    String prodName = sc.next();
                    System.out.print("Enter selling price: ");
                    double sellPrice = sc.nextDouble();
                    System.out.print("Enter available quantity: ");
                    int quantity = sc.nextInt();
                    productDAO.addProduct(new Product(prodId, prodName, sellPrice, quantity));
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    List<Product> allProducts = productDAO.getAllProducts();
                    System.out.println("All Products:");
                    for (Product product : allProducts) {
                        System.out.println(product);
                    }
                    break;

                case 3:
                    System.out.print("Enter item name: ");
                    String itemName = sc.next();
                    System.out.print("Enter item category: ");
                    String category = sc.next();
                    System.out.print("Enter buying price: ");
                    double buyPrice = sc.nextDouble();
                    itemDAO.addItem(new Item(itemName, category, buyPrice));
                    break;

                case 4:
                    System.out.print("Enter category: ");
                    String cat = sc.next();
                    List<Item> items = itemDAO.getItemsByCategory(cat);
                    System.out.println("Items in category " + cat + ":");
                    for (Item item : items) {
                        System.out.println(item);
                    }
                    break;

                case 5:
                    manageUsers(sc, userDAO);
                    break;

                case 6:
                    exitAdmin = true;
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    // Customer actions (view products and view account details)
    private static void customerActions(Scanner sc, ProductDAO productDAO, UserDAO userDAO) {
        boolean exitCustomer = false;

        System.out.print("Enter your username: ");
        String username = sc.next();
        User user = userDAO.getUserByUsername(username);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        while (!exitCustomer) {
            System.out.println("\nCustomer Panel:");
            System.out.println("1. View Available Products");
            System.out.println("2. View Account Details");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    List<Product> products = productDAO.getAllProducts();
                    System.out.println("Available Products:");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;

                case 2:
                    System.out.println("Account Details:");
                    System.out.println(user);
                    break;

                case 3:
                    exitCustomer = true;
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    // Manage users (Admin option)
    private static void manageUsers(Scanner sc, UserDAO userDAO) {
        boolean exitUserMgmt = false;

        while (!exitUserMgmt) {
            System.out.println("\nUser Management:");
            System.out.println("1. View All Users");
            System.out.println("2. Add User");
            System.out.println("3. Remove User");
            System.out.println("4. Back to Admin Menu");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    List<User> users = userDAO.getAllUsers();
                    System.out.println("All Users:");
                    for (User user : users) {
                        System.out.println(user);
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String username = sc.next();
                    System.out.print("Enter email: ");
                    String email = sc.next();
                    System.out.print("Enter password: ");
                    String passw = sc.next();
                    System.out.print("Enter initial SuperCoins: ");
                    int supCoins = sc.nextInt();
                    userDAO.addUser(new User(username, email, passw, supCoins));
                    System.out.println("User added successfully!");
                    break;

                case 3:
                    System.out.print("Enter username to delete: ");
                    String delUsername = sc.next();
                    userDAO.deleteUser(delUsername);
                    break;

                case 4:
                    exitUserMgmt = true;
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

//    // Pre-populate some data
//    private static void prepopulateData(ItemDAO itemDAO, ProductDAO productDAO, UserDAO userDAO) {
//        // Add initial items
//        itemDAO.addItem(new Item("Shampoo", "Personal Care", 120.50));
//        itemDAO.addItem(new Item("Biscuits", "Snacks", 50.00));
//        
//        // Add initial products
//        productDAO.addProduct(new Product(1, "Smartphone", 25000, 10));
//        productDAO.addProduct(new Product(2, "Laptop", 50000, 5));
//
//        // Add initial users
//        userDAO.addUser(new User("john_doe", "john@example.com", "password123", 100));
//        userDAO.addUser(new User("jane_smith", "jane@example.com", "password456", 150));
//    }
}
