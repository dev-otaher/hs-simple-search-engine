package search;

import java.util.Scanner;

public class Main {
    public static Person[] parseData(Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());
        Person[] people = new Person[number];
        for (int i = 0; i < number; i++) {
            String[] data = scanner.nextLine().split(" ");
            Person person = new Person();
            person.firstName = data[0];
            if (data.length > 1) {
                person.lastName = data[1];
            }
            if (data.length > 2) {
                person.email = data[2];
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
            System.out.println("\nFound:");
            for (Person person : result) {
                if (person != null) {
                    System.out.println(person.toString().trim());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person[] people = parseData(scanner);
        System.out.println();
        int queries = Integer.parseInt(scanner.nextLine());
        System.out.println();
        for (int i = 0; i < queries; i++) {
            String query = scanner.nextLine();
            printResult(searchPeople(people, query));
            System.out.println();
        }
    }
}


