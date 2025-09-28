package Task3;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bid, title, author));
                }
                case 2 -> {
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String uname = sc.nextLine();
                    library.addUser(new User(uid, uname));
                }
                case 3 -> library.viewBooks();
                case 4 -> {
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    library.issueBook(bid, uid);
                }
                case 5 -> {
                    System.out.print("Enter Book ID to return: ");
                    int bid = sc.nextInt();
                    library.returnBook(bid);
                }
                case 6 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice, try again!");
            }
        } while (choice != 6);

        sc.close();
    }
}
