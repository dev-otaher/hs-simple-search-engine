package search;

import java.util.Scanner;

public class Main {
    public static Person[] parseData(Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());
        Person[] people = new Person[number];
        for (int i = 0; i < number; i++) {
            String[] data = scanner.nextLine().split(" ");
            Person person = new Person(data[0]);
            if (data.length > 1) {
                person.setLastName(data[1]);
            }
            if (data.length > 2) {
                person.setEmail(data[2]);
            }
            people[i] = person;
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
    }

    public static void printAll(Person[] people) {
        System.out.println("\n=== List of People ===");
        for (Person person : people) {
            System.out.println(person.toString().trim());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person[] people = parseData(scanner);
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
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        } while (choice != 0);
    }
}







