package search;

public class Person {
    String firstName;
    String lastName;
    String email;

    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
    }

    public Person(String firstName) {
        this();
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", firstName, lastName, email);
    }
}
