package iterator_pattern.menu;

import iterator_pattern.data.MenuItem;
import iterator_pattern.iterator.BreakfastHouseMenuIterator;

import java.util.Iterator;

public class BreakfastHouseMenu implements Menu {
    private MenuItem[] menuItems;
    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;

    public BreakfastHouseMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("Full breakfast", "Eggs, sausage, and toast", 5.19, true);
        addItem("Steak and Eggs", "Skirt steak with sunny side up eggs", 7.99, true);
        addItem("Yogurt", "Greek Yogurt with nuts", 2.99, true);
        addItem("Cereal", "Choice of cereal + milk", 2.39, false);
    }

    public void addItem(String name, String description, double price, boolean vegetarian) {
        MenuItem menuItem = new MenuItem(name, description, price, vegetarian);

        if(numberOfItems > MAX_ITEMS) {
            System.out.println("Menu is full, cannot add more items!");
        } else {
            menuItems[numberOfItems++] = menuItem;
        }
    }

    @Override
    public Iterator createIterator() {
        return new BreakfastHouseMenuIterator(menuItems);
    }
}
