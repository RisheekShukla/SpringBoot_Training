package dao;

import java.util.ArrayList;
import java.util.List;
import pojo.User;

public class UserDAO {

    private List<User> users;

    public UserDAO() {
        users = new ArrayList<>();
    }

    // Add a new user
    public void addUser(User user) {
        users.add(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return users;
    }

    // Find a user by username 
    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // Update user details
    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                users.set(i, user);
                return;
            }
        }
        System.out.println("User not found!");
    }

    // Delete a user by username
    public void deleteUser(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                users.remove(i);
                return; 
            }
        }
        System.out.println("User not found!");
    }
}
