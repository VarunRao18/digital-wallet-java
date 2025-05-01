// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User currentUser = null;

        // Main loop to keep the program running
        while (true) {
            System.out.println("\n===== Digital Wallet Menu =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume the newline character

            if (choice == 1) {
                // Register a new user
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                WalletService.registerUser(name, email, password);
            } else if (choice == 2) {
                // Login
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                currentUser = WalletService.login(email, password);

                // Wallet operations menu
                if (currentUser != null) {
                    System.out.println("Welcome, " + currentUser.getName() + "!");
                    while (true) {
                        System.out.println("\n--- Wallet Menu ---");
                        System.out.println("1. Add Money");
                        System.out.println("2. View Balance");
                        System.out.println("3. Logout");
                        System.out.println("4. Withdraw Money");
                        System.out.print("Enter choice: ");
                        int walletChoice = sc.nextInt();

                        if (walletChoice == 1) {
                            // Add money to wallet
                            System.out.print("Enter amount to add: ₹");
                            double amount = sc.nextDouble();
                            WalletService.addMoney(currentUser, amount);
                        } else if (walletChoice == 2) {
                            // View current balance
                            System.out.println("💰 Current Balance: ₹" + currentUser.getBalance());
                        } else if (walletChoice == 3) {
                            // Logout
                            System.out.println("Logging out...");
                            break;
                        } else if (walletChoice == 4) {
                            // Withdraw Money
                            System.out.print("Enter amount to withdraw: ₹");
                            double amount = sc.nextDouble();
                            WalletService.withdrawMoney(currentUser, amount);
                        } else {
                            System.out.println("Invalid option.");
                        }
                    }
                }

            } else if (choice == 3) {
                // Exit the program
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
