package challenge;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Place> places = new LinkedList<>();
        places.add(new Place("Sydney", 0));
        addPlace(places, new Place("Melbourne", 877));
        addPlace(places, new Place("Brisbane", 917));
        addPlace(places, new Place("Adelaide", 1374));
        addPlace(places, new Place("Alice Springs", 2771));
        addPlace(places, new Place("Perth", 3923));
        addPlace(places, new Place("Darwin", 3972));

        try (Scanner scanner = new Scanner(System.in)) {
            navigateItinerary(places, scanner);
        }
    }

    private static void navigateItinerary(LinkedList<Place> places, Scanner scanner) {
        ListIterator<Place> iterator = places.listIterator();
        boolean forward = true;
        boolean running = true;

        printMenu();

        while (running) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim().toUpperCase();

            switch (input) {
                case "F" -> {
                    if (!forward && iterator.hasNext()) iterator.next();
                    forward = true;
                    if (iterator.hasNext()) {
                        System.out.println("Forward to: " + iterator.next());
                    } else {
                        System.out.println("End of the itinerary!");
                        forward = false;
                    }
                }

                case "B" -> {
                    if (forward && iterator.hasPrevious()) iterator.previous();
                    forward = false;
                    if (iterator.hasPrevious()) {
                        System.out.println("Backward to: " + iterator.previous());
                    } else {
                        System.out.println("Beginning of the itinerary!");
                        forward = true;
                    }
                    printMenu();
                }

                case "L" -> {
                    System.out.println("==============================");
                    for (Place place : places) System.out.println(place);
                    System.out.println("==============================");
                }

                case "M" -> printMenu();

                case "Q" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPlace(LinkedList<Place> places, Place newPlace) {
        if (places.contains(newPlace)) {
            System.out.println(newPlace.getName() + " already exists!");
            return;
        }

        ListIterator<Place> iterator = places.listIterator();
        while (iterator.hasNext()) {
            Place current = iterator.next();
            if (newPlace.getDistanceSydney() < current.getDistanceSydney()) {
                iterator.previous();
                iterator.add(newPlace);
                return;
            }
        }
        places.add(newPlace);
    }

    private static void printMenu() {
        System.out.println("====================================");
        System.out.println("Available actions (select word or letter):");
        System.out.println("  (F)orward");
        System.out.println("  (B)ackward");
        System.out.println("  (L)ist Places");
        System.out.println("  (M)enu");
        System.out.println("  (Q)uit");
        System.out.println("=====================================");
    }
}

