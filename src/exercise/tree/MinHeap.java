package exercise.tree;

public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;
    private static final int HEAD = 1;

    public MinHeap(int heapSize) {
        maxSize = heapSize;
        heap = new int[maxSize + 1]; // account for skipping index 0
        heap[0] = Integer.MIN_VALUE; // Since ignoring index 0, set to MIN_VALUE for comparing in insert().
        size = 0;
    }

    public void insert(int value) {
        if (size >= maxSize) {
            System.out.println("Heap is full");
            return;
        }

        heap[++size] = value;
        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void swap(int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int left(int index) {
        return 2 * index;
    }

    private int right(int index) {
        return (2 * index) + 1;
    }

    private boolean isLeaf(int index) {
        return index > size / 2 && index < size;
    }

    public int extract() {
        int minValue = heap[HEAD];
        heap[HEAD] = heap[size--]; // swapping value from tail to head
        heapify(HEAD);
        return minValue;
    }

    private void heapify(int current) {
        if (!isLeaf(current)) {
            int leftIndex = left(current);
            int rightIndex = right(current);

            if (heap[current] > heap[leftIndex] || heap[current] > heap[rightIndex]) {
                if (heap[leftIndex] < heap[rightIndex]) {
                    swap(current, leftIndex);
                    heapify(leftIndex);
                } else {
                    swap(current, rightIndex);
                    heapify(rightIndex);
                }
            }
        }
    }

    public void printHeap() {
        for (int i = 1; i < size + 1; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }
}
