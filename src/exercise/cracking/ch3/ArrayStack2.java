package exercise.cracking.ch3;

import java.util.EmptyStackException;

class ArrayStack2 extends ArrayStack {
    private int[] indexes;

    ArrayStack2() {
        indexes = new int[stackSize];
    }

    public int pop(int stackNumber) {
        throwExceptionIfEmpty(stackNumber);

        int topIndex = getTopIndex(stackNumber);
        int item = numbers[topIndex];
        numbers[topIndex] = 0;
        indexes[stackNumber]--;

        return item;
    }

    public void push(int stackNumber, int item) {
        if (isFull(stackNumber)) {
            throw new RuntimeException("Stack is full");
        }

        indexes[stackNumber]++;
        numbers[getTopIndex(stackNumber)] = item;
    }

    private boolean isEmpty(int stackNumber) {
        return indexes[stackNumber] == 0;
    }

    private boolean isFull(int stackNumber) {
        return indexes[stackNumber] == stackSize;
    }

    private int getTopIndex(int stackNumber) {
        int maxIndex = (stackNumber * stackSize) - 1;
        int offset = stackSize - indexes[stackNumber];
        return (maxIndex - offset);
    }

    public int getTotalSize() {
        return stackSize * NUMBER_OF_STACKS;
    }

    public int peek(int stackNumber) {
        throwExceptionIfEmpty(stackNumber);

        return numbers[getTopIndex(stackNumber)];
    }

    private void throwExceptionIfEmpty(int stackNumber) {
        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }
    }
}
