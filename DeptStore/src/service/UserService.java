package service;

import dao.UserDAO;
import pojo.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    // Register a new user
    public void registerUser(User user) {
        if (userDAO.getUserByUsername(user.getUsername()) == null) {
            userDAO.addUser(user);
        } else {
            System.out.println("User already exists!");
        }
    }

    // Authenticate user
    public boolean authenticateUser(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassw().equals(password)) {
            return true;
        }
        return false;
    }

    // Get all users
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    // Other user-related business logic can be added here
}
