import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by berg on 25/01/17.
 */
public class PageExchange {
    private LinkedList<Page> queue;

    public PageExchange(LinkedList<Page> queue) {
        this.queue = queue;
    }

    public int fifo(int windowSize) {
        int countFaults = 0, equalPagePosition = -1;
        LinkedList<Page> windows = new LinkedList<>(), queueCopy = (LinkedList<Page>) queue.clone();

        Page page = queueCopy.pollFirst();
        while (page.getnProcess() != 0 || page.getnPage() != 0) {

            if (windows.size() < windowSize) windows.addLast(page);
            else {

                equalPagePosition = repetead(windows, page);

                if (equalPagePosition == -1) {
                    windows.removeFirst();
                    windows.addLast(page);
                }
            }

            if (equalPagePosition == -1) countFaults++;
            page = queueCopy.pollFirst();
        }

        return countFaults;
    }

    public int lru(int windowSize) {
        int countFaults = 0, equalPagePosition = -1;
        LinkedList<Page> windows = new LinkedList<>(), queueCopy = (LinkedList<Page>) queue.clone();

        Page page = queueCopy.pollFirst();
        while (page.getnProcess() != 0 || page.getnPage() != 0) {

            if (windows.size() < windowSize) windows.addLast(page);
            else {

                equalPagePosition = repetead(windows, page);

                if (equalPagePosition == -1) windows.removeFirst();
                else windows.remove(equalPagePosition);

                windows.addLast(page);
            }

            if (equalPagePosition == -1) countFaults++;
            page = queueCopy.pollFirst();
        }

        return countFaults;
    }

    public int secondChance(int windowSize) {
        int countFaults = 0, equalPagePosition = -1;
        LinkedList<Page> windows = new LinkedList<>(), queueCopy = (LinkedList<Page>) queue.clone();

        Page page = queueCopy.pollFirst();
        while (page.getnProcess() != 0 || page.getnPage() != 0) {

            if (windows.size() < windowSize) windows.addLast(page);
            else {

                equalPagePosition = repetead(windows, page);
                if (equalPagePosition != -1) windows.get(equalPagePosition).setBit(1);
                else {

                    for (int i = 0; i < windows.size(); i++) {
                        if (windows.get(i).getBit() != 1) {
                            windows.removeFirst();
                            windows.addLast(page);
                            break;
                        }
                    }
                }
            }

            if (equalPagePosition == -1) countFaults++;
            page = queueCopy.pollFirst();
        }

        return countFaults;
    }

    public int secondChanceClock(int windowSize) {
        int countFaults = 0;

        LinkedList<Page> queueCopy = (LinkedList<Page>) queue.clone();
        CircularQueue circularQueue = new CircularQueue();
        Node node = null;

        Page page = queueCopy.pollFirst();
        Node clockHand = null, prevClockHand = null;
        while (page.getnProcess() != 0 || page.getnPage() != 0) {

            if (circularQueue.getSize() < windowSize) {
                circularQueue.add(new Node(null, page, 0));
                prevClockHand = clockHand;
                clockHand = circularQueue.getHead();
            }
            else {
                node = circularQueue.search(page);
                if (node != null) node.setBit(1);
                else if (clockHand.getBit() == 0) {
                    Node newNode = new Node(clockHand.getNext(), page, 0);
                    circularQueue.getTail().setNext(newNode);
                    circularQueue.setHead(newNode);
                } else {
                    clockHand.setBit(0);
                }

                prevClockHand = clockHand;
                clockHand = clockHand.getNext();
            }

            if (node == null) countFaults++;
            page = queueCopy.pollFirst();
            // Falta fazer a lógica para quando todos estiverem com o bit = 1;
        }
        return countFaults;
    }

    private int repetead(LinkedList<Page> windows, Page page) {
        for (int i = 0; i < windows.size(); i++)
            if (windows.get(i).getnPage() == page.getnPage()) return i;

        return -1;
    }

}
