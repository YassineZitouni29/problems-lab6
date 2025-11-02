package problem6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> groceryList = new ArrayList<>();

        int choice;
        do {
            choice = menu(scan);

            switch (choice) {
                case 1:
                    addItem(scan, groceryList);
                    break;
                case 2:
                    removeItem(scan, groceryList);
                    break;
                case 3:
                    printList(groceryList);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scan.close();
    }

    // MENU FUNCTION
    public static int menu(Scanner scan) {
        System.out.println("\n===== Grocery List Menu =====");
        System.out.println("1. Add an item");
        System.out.println("2. Remove an item");
        System.out.println("3. Print list of items");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        return scan.nextInt();
    }

    public static void addItem(Scanner scan, ArrayList<String> list) {
        scan.nextLine(); // consume newline
        System.out.print("Enter the item to add: ");
        String item = scan.nextLine().trim().toLowerCase();

        if (list.contains(item)) {
            System.out.println("Item already exists in the list!");
        } else {
            list.add(item);
            Collections.sort(list);
            System.out.println("Item added successfully!");
        }

        printList(list);
    }

    public static void removeItem(Scanner scan, ArrayList<String> list) {
        scan.nextLine(); // consume newline
        System.out.print("Enter the item to remove: ");
        String item = scan.nextLine().trim().toLowerCase();

        if (list.remove(item)) {
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item not found in the list.");
        }

        Collections.sort(list);
        printList(list);
    }

    public static void printList(ArrayList<String> list) {
        System.out.println("\nCurrent Grocery List:");
        if (list.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (String i : list) {
                System.out.println("- " + i);
            }
        }
    }
}

