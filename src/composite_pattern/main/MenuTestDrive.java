package composite_pattern.main;

import composite_pattern.client.Waitress;
import composite_pattern.component.Menu;
import composite_pattern.component.MenuComponent;
import composite_pattern.component.MenuItem;

public class MenuTestDrive {
    public static void main(String[] args) {
        MenuComponent pancakeMenu = new Menu("Pancake Menu", "Taste pancakes on the menu");
        MenuComponent breakfastMenu = new Menu("Breakfast Menu", "Good breakfast on in the house");
        MenuComponent cafeMenu = new Menu("Cafe Menu", "Yummy lunch in the cafeteria");

        MenuComponent allMenus = new Menu("All Menus", "This has all the menus");
        allMenus.add(pancakeMenu);
        allMenus.add(breakfastMenu);
        allMenus.add(cafeMenu);

        pancakeMenu.add(new MenuItem("Pancake", "4 fluffy pancakes", 3.29, true));
        pancakeMenu.add(new MenuItem("Blueberry Pancake", "Blueberry fluffy pancakes", 4.19, true));
        pancakeMenu.add(new MenuItem("Waffles", "Waffles with choice of jam", 3.79, true));
        pancakeMenu.add(new MenuItem("Breakfast Pancake", "Sausage, eggs, and pancakes", 5.89, false));

        breakfastMenu.add(new MenuItem("Full breakfast", "Eggs, sausage, and toast", 5.19, true));
        breakfastMenu.add(new MenuItem("Steak and Eggs", "Skirt steak with sunny side up eggs", 7.99, true));
        breakfastMenu.add(new MenuItem("Yogurt", "Greek Yogurt with nuts", 2.99, true));
        breakfastMenu.add(new MenuItem("Cereal", "Choice of cereal + milk", 2.39, false));

        cafeMenu.add(new MenuItem("Soup of the Day", "Delicious soup with onion", 2.89, true));
        cafeMenu.add(new MenuItem("Classic Burger", "Burger with tomato, onion, salad and side of fries", 6.79, false));
        cafeMenu.add(new MenuItem("Side Salad", "Salad with croutons", 3.39, true));

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
        waitress.printVegetarianMenu();
    }
}
