/**
 * Created by berg on 27/01/17.
 */
public class CircularQueue {
    private Node head;
    private Node tail;
    private int size;

    public CircularQueue() {

    }

    public boolean add(Node node) {
        if (node == null) return false;

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.tail.setNext(this.head);
        this.size++;
        return true;
    }

    public boolean add(Node node, int index) {
        if (index < 0 || index >= this.size) return false;

        int i = 0;
        Node current = this.head;
        Node previous = null;
        while (i != index) {
            i++;
            previous = current;
            current = current.getNext();
        }
        node.setNext(current.getNext());
        previous.setNext(node);
        this.size++;
        return true;
    }

    public Node search(Page page) {
        Node current = this.head;
        while (current != null) {

            if (current.getPage().getnPage() == page.getnPage())
                return current;

            current = current.getNext();
            if (current.getPage().getnPage() == this.head.getPage().getnPage())
                return null;
        }
        return null;
    }

    private boolean isEmpty() {
        return this.head == null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}

