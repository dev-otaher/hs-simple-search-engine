package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String word = scanner.nextLine();
        if (input.contains(word)) {
            String substring = input.substring(0, input.indexOf(word) + word.length());
            System.out.println(substring.split(" ").length);
        } else {
            System.out.println("Not found");
        }
    }
}
