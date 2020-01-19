package iterator_pattern.menu;

import iterator_pattern.data.MenuItem;

import java.util.HashMap;
import java.util.Iterator;

public class CafeMenu implements Menu {
    HashMap<String, MenuItem> menus;

    public CafeMenu() {
        menus = new HashMap<>();

        addItem("Soup of the Day", "Delicious soup with onion", 2.89, true);
        addItem("Classic Burger", "Burger with tomato, onion, salad and side of fries", 6.79, false);
        addItem("Side Salad", "Salad with croutons", 3.39, true);
    }

    public void addItem(String name, String description, double price, boolean vegetarian) {
        MenuItem menuItem = new MenuItem(name, description, price, vegetarian);
        menus.put(menuItem.getName(), menuItem);
    }

    @Override
    public Iterator createIterator() {
        return menus.values().iterator();
    }
}
