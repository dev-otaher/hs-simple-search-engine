package search;

public class Menu {
    private MenuItem[] items;

    public Menu() {
        items = new MenuItem[3];
        items[0] = new MenuItem(1, "Search information.");
        items[1] = new MenuItem(2, "Print all data.");
        items[2] = new MenuItem(0, "Exit.");
    }

    public void print() {
        System.out.println("\n=== Menu ===");
        for (MenuItem item : items) {
            System.out.println(item);
        }
    }
}
