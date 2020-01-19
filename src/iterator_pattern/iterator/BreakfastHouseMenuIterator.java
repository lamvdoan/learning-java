package iterator_pattern.iterator;

import iterator_pattern.data.MenuItem;

import java.util.Iterator;

public class BreakfastHouseMenuIterator implements Iterator {
    private MenuItem[] menuItems;
    int position = 0;

    public BreakfastHouseMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position >= menuItems.length || menuItems[position] == null ? false : true;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems[position++];
        return menuItem;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("Need to call at least one next()!");
        } else {
            if (menuItems[position - 1] != null) {
                for (int i = position - 1; i < menuItems.length - 1; i++) {
                    menuItems[i] = menuItems[i + 1];
                }

                menuItems[menuItems.length - 1] = null;
            }
        }
    }
}
