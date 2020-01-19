package exercise.z_data;

public class LinkedListNode {
    public LinkedListNode next, prev, last;
    public int data;

    public LinkedListNode(int data,
                          LinkedListNode next,
                          LinkedListNode prev) {
        this.data = data;
        setNext(next);
        setPrevious(prev);
    }

    public LinkedListNode(int data) {
        this.data = data;
    }

    public LinkedListNode() {
    }

    public void setNext(LinkedListNode next) {
        this.next = next;

        if (last == this) {
            last = next;
        }

        // ensure next.prev = this
        if (next != null && next.prev != this) {
            next.setPrevious(this);
        }
    }

    public void setPrevious(LinkedListNode prev) {
        this.prev = prev;

        // ensure tail.next = this
        if (prev != null && prev.next != this) {
            prev.setNext(this);
        }
    }

    public LinkedListNode clone() {
        LinkedListNode next2 = null;

        // clone the next and future nexts for this cloned node
        if (next != null) {
            next2 = next.clone();
        }

        // clone node, and next2 may have a next or just be a null
        return new LinkedListNode(data, next2, null);
    }
}
