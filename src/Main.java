import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        LinkedList<Page> input = readFile(args[3]);
        int windowSize = 3;
//        for (int i = 0; i < input.size(); i++)
//            System.out.println(input.get(i).toString());

        PageExchange pageExchange = new PageExchange(input);
        if (args[0].equals("on")) {
            System.out.println("FIFO -> Count Faults: " + pageExchange.fifo(windowSize));
        }
        if (args[1].equals("on")) {
            System.out.println("LRU -> Count Faults: " + pageExchange.lru(windowSize));
        }
        if (args[2].equals("on")) {
            System.out.println("SECOND CHANCE -> Count Faults: " + pageExchange.secondChanceClock(windowSize));
        }
    }

    private static LinkedList<Page> readFile(String path) throws IOException {
        BufferedReader txt = new BufferedReader(new FileReader(path));

        String str = "";
        while(txt.ready()) str += txt.readLine();
        txt.close();

        String[] l = str.split(";");
        LinkedList<Page> lst = new LinkedList<>();

        for (int i = 0; i < l.length; i++) {
            String a[] = l[i].split(",");
            lst.addLast(new Page(Integer.parseInt(a[0]), Integer.parseInt(a[1])));
        }

        return lst;
    }
}
