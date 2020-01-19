package composite_pattern.client;

import composite_pattern.component.MenuComponent;

import java.util.Iterator;

public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }

    public void printVegetarianMenu() {
        System.out.println("\nVegetarian Menu");
        System.out.println("----------------------");

        Iterator iterator = allMenus.createIterator();

        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();

            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {
                // Ignore if menuComponent is Menu
            }
        }
    }
}
