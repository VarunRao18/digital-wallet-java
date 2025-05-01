// WalletService.java
import java.util.*;

public class WalletService {
    // In-memory database of users
    private static Map<String, User> users = new HashMap<>();

    // Register a new user
    public static void registerUser(String name, String email, String password) {
        if (users.containsKey(email)) {
            System.out.println("User already exists!");
        } else {
            User newUser = new User(name, email, password);
            users.put(email, newUser);
            System.out.println("User registered successfully!");
        }
    }

    // Login user
    public static User login(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            System.out.println("Invalid login credentials!");
            return null;
        }
    }

    // Add money to user's wallet
    public static void addMoney(User user, double amount) {
        if (amount > 0) {
            user.setBalance(user.getBalance() + amount);
            System.out.println("₹" + amount + " added to your wallet. Current balance: ₹" + user.getBalance());
        } else {
            System.out.println("Amount must be positive!");
        }
    }

    // Withdraw money from user's wallet
    public static void withdrawMoney(User user, double amount) {
        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance!");
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
        } else {
            user.setBalance(user.getBalance() - amount);
            System.out.println("₹" + amount + " withdrawn. New balance: ₹" + user.getBalance());
        }
    }
}
