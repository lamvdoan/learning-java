package composite_pattern.iterator;

import composite_pattern.component.Menu;
import composite_pattern.component.MenuComponent;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {
    private Stack stack;

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack = new Stack();
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator iterator = (Iterator) stack.peek();

            if (iterator.hasNext()) {
                return true;
            } else {
                // Remove the empty iterator, aka most recently pushed iterator
                stack.pop();
                return hasNext();
            }
        }
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent menuComponent = (MenuComponent) iterator.next();

            if (menuComponent instanceof Menu) {
                stack.push(menuComponent.createIterator());
            }

            return menuComponent;
        }

        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
