package exercise.z_data;

public class Node {
    public Node next = null;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    public void appendToTail(int data) {
        Node end = new Node(data);
        Node node = this;

        while (node.next != null) {
            node = node.next;
        }

        node.next = end;
    }
}
