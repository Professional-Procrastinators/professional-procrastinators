package main.java.org.launchcode.professionalprocrastinators.controllers;

import org.launchcode.professionalprocrastinators.models.*;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserAuthentication {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(User user) {
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(User user) {
        Optional<User> optionalUser = userRepository.findByEmailOrName(user.getEmail(), user.getName());
        // Add login logic using optionalUser
        return "redirect:/dashboard";
    }
}

/*public class UserAuthentication {
    @Autowired
    private UserRepository userRepository;
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

 */