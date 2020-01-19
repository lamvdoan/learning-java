package iterator_pattern.menu;

import iterator_pattern.data.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu {
    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();

        addItem("Pancake", "4 fluffy pancakes", 3.29, true);
        addItem("Blueberry Pancake", "Blueberry fluffy pancakes", 4.19, true);
        addItem("Waffles", "Waffles with choice of jam", 3.79, true);
        addItem("Breakfast Pancake", "Sausage, eggs, and pancakes", 5.89, false);
    }

    public void addItem(String name, String description, double price, boolean vegetarian) {
        MenuItem menuItem = new MenuItem(name, description, price, vegetarian);
        menuItems.add(menuItem);
    }

    @Override
    public Iterator createIterator() {
        return menuItems.iterator();
    }
}
