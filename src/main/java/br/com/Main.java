package br.com;

import br.com.service.UserService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int userMenu;

        Scanner scanner = new Scanner(System.in);
        UserService service = new UserService();

        do {
            //Acess User Tab
            System.out.println("\n====================");
            System.out.println("USER MANEGEMENT");
            System.out.println("====================");
            System.out.println("1 - Register user");
            System.out.println("2 - View registered users");
            System.out.println("3 - Change username");
            System.out.println("4 - Remove user");
            System.out.println("5 - Exit\n");

            System.out.println("Choose an option (1-5):");
            userMenu = scanner.nextInt();
            scanner.nextLine();

            switch (userMenu) {
                case 1:
                    service.registerUser(scanner);
                    break;
                case 2:
                    service.listAllUsers();
                    break;
                case 3:
                    service.changeUsername(scanner);
                    break;
                case 4:
                    service.removeUser(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
            }
        }while(userMenu >= 1 && userMenu < 6);

        scanner.close();
    }
}