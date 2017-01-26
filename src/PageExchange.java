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
        int countFaults = 0;
        boolean equal = false;
        LinkedList<Page> windows = new LinkedList<>(), queueCopy = (LinkedList<Page>) queue.clone();

        Page page = queueCopy.pollFirst();
        while (page.getnProcess() != 0 || page.getnPage() != 0) {

            if (windows.size() < windowSize) windows.addLast(page);
            else {

                equal = repetead(windows, page);

                if (!equal) {
                    windows.removeFirst();
                    windows.addLast(page);
                }
            }

            if (!equal) countFaults++;
            page = queueCopy.pollFirst();
        }

        return countFaults;
    }

    public int lru(int windowSize) {
        int countFaults = 0;
        return countFaults;
    }

    public int secondChance(int windowSize) {
        int countFaults = 0;
        return countFaults;
    }

    private boolean repetead(LinkedList<Page> windows, Page page) {
        for (int i = 0; i < windows.size(); i++)
            if (windows.get(i).getnPage() == page.getnPage()) return true;

        return false;
    }

}
