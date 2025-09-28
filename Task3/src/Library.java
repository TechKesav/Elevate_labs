package Task3;

import java.util.ArrayList;

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println(" Book added: " + book.getTitle());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }
    public void issueBook(int bookId, int userId) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                if (!b.isIssued()) {
                    b.issue();
                    System.out.println("Book '" + b.getTitle() + "' issued to User ID: " + userId);
                } else {
                    System.out.println("Book already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                if (b.isIssued()) {
                    b.returnBook();
                    System.out.println(" Book '" + b.getTitle() + "' returned successfully.");
                } else {
                    System.out.println(" Book was not issued.");
                }
                return;
            }
        }
        System.out.println(" Book not found.");
    }
}

