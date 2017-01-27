/**
 * Created by berg on 27/01/17.
 */
public class Node {
    private Node next;
    private Page page;
    private int bit;

    public Node(Node next, Page page, int bit) {
        this.next = next;
        this.page = page;
        this.bit = bit;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public String toString() {
        return this.page.getnProcess() + " " + this.page.getnPage() + " " + this.bit;
    }
}
