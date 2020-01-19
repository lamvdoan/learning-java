package iterator_pattern.main;

import iterator_pattern.client.Waitress;
import iterator_pattern.menu.BreakfastHouseMenu;
import iterator_pattern.menu.CafeMenu;
import iterator_pattern.menu.Menu;
import iterator_pattern.menu.PancakeHouseMenu;

import java.util.ArrayList;

public class MenuTestDrive {
    public static void main(String[] args) {
        ArrayList<Menu> menus = new ArrayList();
        PancakeHouseMenu pancakeMenu = new PancakeHouseMenu();

        menus.add(pancakeMenu);
        menus.add(new BreakfastHouseMenu());
        menus.add(new CafeMenu());

        pancakeMenu.addItem("Breakfast Pancake 2", "Sausage, eggs, and pancake 2s", 2.22, false);
        Waitress waitress = new Waitress(menus);
        waitress.printMenu();

    }

    public static void some(ArrayList list) {
        System.out.println("It works!");
    }
}
