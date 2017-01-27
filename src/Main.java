import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        LinkedList<Page> input = readFile("");
        int windowSize = 3;
//        for (int i = 0; i < input.size(); i++)
//            System.out.println(input.get(i).toString());

        PageExchange pageExchange = new PageExchange(input);
        switch ("2") {
            case "0":
                System.out.println("FIFO -> Count Faults: " + pageExchange.fifo(windowSize));
                break;
            case "1":
                System.out.println("LRU -> Count Faults: " + pageExchange.lru(windowSize));
                break;
            case "2":
                System.out.println("SECOND CHANCE -> Count Faults: " + pageExchange.secondChance(windowSize));
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static LinkedList<Page> readFile(String path) throws IOException {
//        BufferedReader txt = new BufferedReader(new FileReader(path));

        String str = "1,0;2,2;3,1;4,3;5,5;6,4;7,6;8,3;9,7;10,4;11,7;12,3;13,3;14,5;15,5;16,3;17,1;18,1;19,1;20,7;21,1;22,3;23,4;24,1;0,0";
//        while(txt.ready()) str += txt.readLine();
//        txt.close();

        String[] l = str.split(";");
        LinkedList<Page> lst = new LinkedList<>();

        for (int i = 0; i < l.length; i++) {
            String a[] = l[i].split(",");
            lst.addLast(new Page(Integer.parseInt(a[0]), Integer.parseInt(a[1])));
        }

        return lst;
    }
}
