package exercise.cracking.ch3;

class ArrayStack1 extends ArrayStack {
    private static final int STACK_ONE = 1;
    private static final int STACK_TWO = 2;
    private static final int STACK_THREE = 3;
    private int index0 = 0;
    private int index1 = stackSize;
    private int index2 = stackSize * 2;

    public int pop(int stackNumber) {
        if ((stackNumber == STACK_ONE && index0 == 0)
                || (stackNumber == STACK_TWO && index0 == stackSize)
                || (stackNumber == 2 && index0 == stackSize * 2)) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int item = 0;
        if (stackNumber == STACK_ONE) {
            item = numbers[--index0];
        } else if (stackNumber == STACK_TWO) {
            item = numbers[--index1];
        } else if (stackNumber == STACK_THREE) {
            item = numbers[--index2];
        }

        return item;
    }

    public void push(int stackNumber, int item) {
        if ((stackNumber == STACK_ONE && index0 == stackSize - 1)
                || (stackNumber == STACK_TWO && index0 == (stackSize * 2) - 1)
                || (stackNumber == STACK_THREE && index0 == (stackSize * 3) - 1)) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (stackNumber == STACK_ONE) {
            numbers[index0++] = item;
        } else if (stackNumber == STACK_TWO) {
            numbers[index1++] = item;
        } else if (stackNumber == STACK_THREE) {
            numbers[index2++] = item;
        }
    }

    public boolean isEmpty(int stackNumber) {
        if (stackNumber == STACK_ONE) {
            return index0 == 0;
        } else if (stackNumber == STACK_TWO) {
            return index1 == stackSize;
        } else if (stackNumber == STACK_THREE) {
            return index2 == stackSize;
        }

        return false;
    }

    public boolean isFull(int stackNumber) {
        if (stackNumber == STACK_ONE) {
            return index0 == stackSize - 1;
        } else if (stackNumber == STACK_TWO) {
            return index1 == (stackSize * 2) - 1;
        } else if (stackNumber == STACK_THREE) {
            return index2 == (stackSize * 3) - 1;
        }

        return false;
    }
}
