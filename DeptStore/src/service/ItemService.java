package service;

import dao.ItemDAO;
import pojo.Item;

import java.util.List;

public class ItemService {

    private ItemDAO itemDAO;

    public ItemService() {
        itemDAO = new ItemDAO();
    }

    // Add a new item
    public void addItem(Item item) {
        itemDAO.addItem(item);
    }

    // Get items by category
    public List<Item> getItemsByCategory(String category) {
        return itemDAO.getItemsByCategory(category);
    }

    // Get all items
    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    // Delete an item
    public void deleteItem(String itemName, String category) {
        itemDAO.deleteItem(itemName, category);
    }

}
