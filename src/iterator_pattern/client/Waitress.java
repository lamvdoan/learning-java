package iterator_pattern.client;

import iterator_pattern.data.MenuItem;
import iterator_pattern.menu.Menu;

import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
    ArrayList<Menu> menus;

    public Waitress(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public void printMenu() {
        for (Menu menu : menus) {
            System.out.println("\n" + menu.getClass().getSimpleName());
            System.out.println("------------------");
            printMenuItems(menu.createIterator());
        }
    }

    private void printMenuItems(Iterator menuIterator) {
        while (menuIterator.hasNext()) {
            MenuItem menuItem = (MenuItem) menuIterator.next();

            System.out.println(
                    menuItem.getName() + " - " +
                    menuItem.getDescription() + ": $" +
                    menuItem.getPrice()
            );
        }
    }
}
