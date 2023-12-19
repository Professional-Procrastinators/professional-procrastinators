package main.java.org.launchcode.professionalprocrastinators.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserAuthentication {
    private static Map<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().toLowerCase();

        if (userDatabase.containsKey(username)) {
            System.out.println("Username already exists. Choose another one.");
        } else {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (password.matches(".*\\d.*")) {
                System.out.println("Password cannot contain numbers. Please choose another password.");
            } else {
                userDatabase.put(username, password);
                System.out.println("User registered successfully!");
            }
        }
    }

    private static void loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().toLowerCase();

        if (userDatabase.containsKey(username)) {
            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            if (enteredPassword.equals(userDatabase.get(username))) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Incorrect password. Login failed.");
            }
        } else {
            System.out.println("Username not found. Please register first.");
        }
    }
}