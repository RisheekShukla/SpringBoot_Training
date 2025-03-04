package service;

import dao.ItemDAO;
import dao.UserDAO;
import pojo.Item;
import pojo.User;

import java.util.List;

public class CustomerService {
    private UserDAO userDAO;
    private ItemDAO itemDAO;

    public CustomerService() {
        userDAO = new UserDAO();
        itemDAO = new ItemDAO();
    }

    // Register a new customer
    public void registerCustomer(User user) {
        if (userDAO.getUserByUsername(user.getUsername()) == null) {
            userDAO.addUser(user);
            System.out.println("Customer registered: " + user.getUsername());
        } else {
            System.out.println("Username already exists.");
        }
    }

    // Customer login
    public User loginCustomer(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassw().equals(password)) {
            System.out.println("Login successful for: " + username);
            return user;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }

    // View all items
    public List<Item> viewAllItems() {
        return itemDAO.getAllItems();
    }

    // Filter items by category
    public List<Item> filterItemsByCategory(String category) {
        return itemDAO.getItemsByCategory(category);
    }

    // Filter items by price
    public List<Item> filterItemsByPrice() {
        List<Item> allItems = itemDAO.getAllItems();
        allItems.sort((item1, item2) -> Double.compare(item1.getBuy_price(), item2.getBuy_price()));
        return allItems;
    }

    // View specific item details
    public Item getItemDetails(String itemName, String category) {
        List<Item> itemsInCategory = itemDAO.getItemsByCategory(category);
        for (Item item : itemsInCategory) {
            if (item.getItem_name().equals(itemName)) {
                return item;
            }
        }
        System.out.println("Item not found in category: " + category);
        return null;
    }
}
