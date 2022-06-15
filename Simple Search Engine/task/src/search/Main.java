package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Person createPerson(String[] data) {
        String firstName = data[0];
        Person person = new Person(firstName);
        if (data.length > 1) {
            person.setLastName(data[1]);
        }
        if (data.length > 2) {
            person.setEmail(data[2]);
        }
        return person;
    }

    public static List<Person> parseData(Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String[] data = scanner.nextLine().split(" ");
            people.add(createPerson(data));
        }
        return people;
    }

    public static List<Person> parseData(File file) {
        List<Person> people = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(" ");
                people.add(createPerson(data));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    public static void printResult(List<Person> result) {
        if (result.size() == 0) {
            System.out.println("No match.");
        } else {
            for (Person person : result) {
                System.out.println(person.toString().trim());
            }
        }
        System.out.println();
    }

    public static void printAll(List<Person> people) {
        System.out.println("\n=== List of People ===");
        for (Person person : people) {
            System.out.println(person.toString().trim());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String filename = args[1];
        Engine engine = new Engine(parseData(new File(filename)));
        Menu menu = new Menu();
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            menu.print();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    String query = scanner.nextLine();
                    printResult(engine.search(query));
                    break;
                case 2:
                    printAll(engine.getPeople());
                    break;
                case 0:
                    System.out.println("\nBye!");
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        } while (choice != 0);
    }
}