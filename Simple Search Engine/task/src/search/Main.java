package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static void insertPerson(Person[] people, int i, String[] data) {
        Person person = new Person(data[0]);
        if (data.length > 1) {
            person.setLastName(data[1]);
        }
        if (data.length > 2) {
            person.setEmail(data[2]);
        }
        people[i] = person;
    }

    public static Person[] parseData(Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());
        Person[] people = new Person[number];
        for (int i = 0; i < number; i++) {
            String[] data = scanner.nextLine().split(" ");
            insertPerson(people, i, data);
        }
        return people;
    }

    public static Person[] parseData(String fileName) {
        Person[] people = new Person[0];
        try {
            String[] input = new String(Files.readAllBytes(Paths.get(fileName))).split("\n");
            people = new Person[input.length];
            for (int i = 0; i < people.length; i++) {
                String[] data = input[i].split(" ");
                insertPerson(people, i, data);
            }
        } catch (IOException e) {
            System.out.println("No such file!");
        }
        return people;
    }

    public static Person[] searchPeople(Person[] people, String query) {
        Person[] result = new Person[people.length];
        for (int i = 0; i < people.length; i++) {
            if (people[i].toString().toLowerCase().contains(query.toLowerCase())) {
                result[i] = people[i];
            }
        }
        return result;
    }

    public static boolean isArrayElementsNull(Object[] array) {
        for (Object obj : array) {
            if (obj != null) {
                return false;
            }
        }
        return true;
    }

    public static void printResult(Person[] result) {
        if (isArrayElementsNull(result)) {
            System.out.println("No match.");
        } else {
            for (Person person : result) {
                if (person != null) {
                    System.out.println(person.toString().trim());
                }
            }
        }
        System.out.println();
    }

    public static void printAll(Person[] people) {
        System.out.println("\n=== List of People ===");
        for (Person person : people) {
            System.out.println(person.toString().trim());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String filename = args[1];
        Scanner scanner = new Scanner(System.in);
        Person[] people = parseData(filename);
        Menu menu = new Menu();
        int choice;
        do {
            menu.print();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    String query = scanner.nextLine();
                    printResult(searchPeople(people, query));
                    break;
                case 2:
                    printAll(people);
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