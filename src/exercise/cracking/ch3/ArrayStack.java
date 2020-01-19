package exercise.cracking.ch3;

public abstract class ArrayStack {
    protected static final int NUMBER_OF_STACKS = 3;
    protected int stackSize = 5;
    public int[] numbers;

    public ArrayStack() {
        numbers = new int[stackSize * NUMBER_OF_STACKS];

    }

    abstract void push(int stackNumber, int item);
    abstract int pop(int stackNumber);

    public int getTotalSize() {
        return stackSize * NUMBER_OF_STACKS;
    }
}
