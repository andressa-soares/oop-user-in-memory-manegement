package service;

import model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    List<User> userList = new ArrayList<>();

    public void registerUser(Scanner scanner) {
        String name;
        String username;
        String email;
        String phone;
        boolean isValidEmail;
        boolean isValidPhone;

        System.out.println("\n>>Register Your User<<\n");

        System.out.println("Enter your name:");
        name = scanner.nextLine().trim();
        System.out.println("Enter your username:");
        username = scanner.nextLine().replaceAll("\\s+", "");

        do {
            System.out.println("Enter your email:");
            email = scanner.nextLine().trim();
            isValidEmail = validateEmail(email);
        }while(!isValidEmail);

        do {
            System.out.println("Enter your phone number:");
            phone = scanner.nextLine().trim();
            isValidPhone = validatePhone(phone);
        }while(!isValidPhone);

        User user = new User(name, username, email, phone);

        userList.add(user);
        System.out.println(userList);

        System.out.println("\nUser successfully registered!");
        System.out.println("Total registered users: " + userList.size());
    }

    public void listAllUsers() {
        System.out.println("\n>>All Registered Users<<");

        if (userList.isEmpty()) {
            System.out.println("\nNo users registered yet.");
            return;
        }

        for (User user : userList) {
            System.out.println("\nName: " + user.getName());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Phone number: " + formatPhone(user.getPhone()));
        }
    }

    public void removeUser(Scanner scanner) {
        System.out.println("Enter the user's email to remove:");
        String emailToRemove = scanner.nextLine().trim();

        for (int i = 0; i < userList.size(); i++) {
            if (emailToRemove.equalsIgnoreCase(userList.get(i).getEmail())) {
                userList.remove(i);
                System.out.println("User removed successfully!");
                return;
            }
        }

        System.out.println("No user found with that email.");
    }

    public void changeUsername(Scanner scanner) {
        System.out.println("Enter the username to change:");
        String usernameToChange = scanner.nextLine().trim();

        for (int i = 0; i < userList.size(); i++) {
            if (usernameToChange.equalsIgnoreCase(userList.get(i).getUsername())) {
                System.out.println("Enter the new username:");
                String newUsername = scanner.nextLine();
                userList.get(i).setUsername(newUsername);
                System.out.println("User changed successfully!");
                return;
            }
        }

        System.out.println("No user found with that username.");
    }

    private static String formatPhone(String phone) {
        return String.format("(%s) %s-%s",
                phone.substring(0, 2),
                phone.substring(2, 7),
                phone.substring(7));
    }

    private static boolean validateEmail(String email) {
        boolean isValidEmail = false;

        if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            isValidEmail = true;
        } else {
            System.out.println("Invalid email! Please register again.");
        }

        return isValidEmail;
    }

    private static boolean validatePhone(String phone) {
        boolean isValidPhone = false;

        if (phone.matches("\\d{11}")) {
            isValidPhone = true;
        } else {
            System.out.println("Invalid phone number! Please register again.");
        }

        return isValidPhone;
    }
}