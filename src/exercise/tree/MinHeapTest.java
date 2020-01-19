package exercise.tree;

public class MinHeapTest {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(20);
        heap.insert(5);
        heap.insert(2);
        heap.insert(7);
        heap.insert(1);
        heap.insert(9);
        heap.insert(8);
        heap.extract();
        heap.insert(3);
        heap.extract();

        heap.printHeap();
        // 3, 5, 7, 8, 9
    }
}
