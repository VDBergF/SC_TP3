import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        LinkedList<Page> input = readFile(args[1]);
        int windowSize = 3;
//        for (int i = 0; i < input.size(); i++)
//            System.out.println(input.get(i).toString());

        PageExchange pageExchange = new PageExchange(input);
        switch (args[0]) {
            case "0":
                System.out.println(pageExchange.fifo(windowSize));
                break;
            case "1":
                System.out.println(pageExchange.lru(windowSize));
                break;
            case "2":
                System.out.println(pageExchange.secondChance(windowSize));
                break;
            default:
                System.out.println("Opção inválida!");
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
