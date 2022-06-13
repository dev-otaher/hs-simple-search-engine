package search;

public class Person {
    String firstName = "";
    String lastName = "";
    String email = "";

    @Override
    public String toString() {
        return String.format("%s %s %s", firstName, lastName, email);
    }
}
