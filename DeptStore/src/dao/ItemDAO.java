package dao;

import java.util.*;
import pojo.Item;

public class ItemDAO {
    private Map<String, List<Item>> categoryItemMap;

    public ItemDAO() {
        categoryItemMap = new HashMap<>();
    }

    // Add an item to a category 
    public void addItem(Item item) {
        List<Item> itemList = categoryItemMap.get(item.getCategory());
        if (itemList == null) {
            itemList = new ArrayList<>();
            categoryItemMap.put(item.getCategory(), itemList);
        }
        itemList.add(item);  // Add the item to the category list
        System.out.println("Item added: " + item.getItem_name() + " in " + item.getCategory());
    }

    // Get items by category
    public List<Item> getItemsByCategory(String category) {
        return categoryItemMap.getOrDefault(category, new ArrayList<>());
    }

    // Get all items
    public List<Item> getAllItems() {
        List<Item> allItems = new ArrayList<>();
        for (List<Item> items : categoryItemMap.values()) {
            allItems.addAll(items);  // Add all items from all categories to the list
        }
        return allItems;
    }

    // Delete an item
    public void deleteItem(String itemName, String category) {
        List<Item> items = categoryItemMap.get(category);
        if (items != null) {
            for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
                Item item = iterator.next();
                if (item.getItem_name().equals(itemName)) {
                    iterator.remove();  // Remove item if the name matches
                    System.out.println("Item removed: " + itemName + " from " + category);
                    break;  // Exit after removing the item
                }
            }
        }
    }
}
