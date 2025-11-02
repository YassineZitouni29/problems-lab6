package problem3;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int capacity;
        do {
            System.out.println("enter the number of documents");
            capacity = scan.nextInt();
        } while (capacity <= 0);

        Library library = new Library(capacity);
        Book book = new Book("Quantum physics", "Stephen Hawking", 330);
        Dictionary dict = new Dictionary("Le Robert", "French");
        library.add(book);
        library.add(dict);

        int choice;
        do {
            choice = menu(scan);

            switch (choice) {
                case 1:
                    addDocument(scan, library);
                    break;

                case 2:
                    deleteDocument(scan, library);
                    break;

                case 3:
                    library.displayDocuments();
                    break;

                case 4:
                    library.DisplayAuthors();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 0);
    }

    // ---------- MENU ----------
    public static int menu(Scanner scan) {
        System.out.println("\n========= LIBRARY MENU =========");
        System.out.println("1. Add a document");
        System.out.println("2. Delete a document");
        System.out.println("3. Display all documents");
        System.out.println("4. Display authors (Books only)");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        return scan.nextInt();
    }

    // ---------- ADD DOCUMENT ----------
    public static void addDocument(Scanner scan, Library library) {
        System.out.println("\nChoose document type to add:");
        System.out.println("1. Book");
        System.out.println("2. Dictionary");
        System.out.println("3. Magazine");
        System.out.print("Your choice: ");
        int type = scan.nextInt();
        scan.nextLine(); // consume newline

        Document doc = null;

        switch (type) {
            case 1:
                System.out.print("Enter title: ");
                String titleB = scan.nextLine();
                System.out.print("Enter author: ");
                String author = scan.nextLine();
                System.out.print("Enter number of pages: ");
                int pages = scan.nextInt();
                doc = new Book(titleB, author, pages);
                break;

            case 2:
                System.out.print("Enter title: ");
                String titleD = scan.nextLine();
                System.out.print("Enter language: ");
                String language = scan.nextLine();
                doc = new Dictionary(titleD, language);
                break;

            case 3:
                System.out.print("Enter title: ");
                String titleM = scan.nextLine();
                System.out.print("Enter month: ");
                String month = scan.nextLine();
                System.out.print("Enter year: ");
                int year = scan.nextInt();
                doc = new Magazine(titleM, month, year);
                break;

            default:
                System.out.println("Invalid document type.");
                return;
        }

        if (library.add(doc))
            System.out.println("Document added successfully!");
        else
            System.out.println("Failed to add (duplicate or library full).");
    }

    // ---------- DELETE DOCUMENT ----------
    public static void deleteDocument(Scanner scan, Library library) {
        System.out.print("Enter record number to delete: ");
        int num = scan.nextInt();
        Document doc = library.document(num);
        if (doc != null && library.delete(doc))
            System.out.println("Document deleted successfully!");
        else
            System.out.println("Document not found.");
    }
}


