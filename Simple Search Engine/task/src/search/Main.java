package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String word = scanner.nextLine();
        System.out.println(input.length());
        if (input.contains(word)) {
            System.out.println(input.indexOf(word));
        } else {
            System.out.println("Not found");
        }
    }
}
