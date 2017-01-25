import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!");
        ArrayList<Integer> inputList = readFile(args[2]);
    }

    private static ArrayList<Integer> readFile(String path) throws IOException {
        ArrayList<Integer> inputList = new ArrayList<>();
        BufferedReader txt = new BufferedReader(new FileReader(path));

        while(txt.ready()){
            String linha = txt.readLine();
            System.out.println(linha);
        }
        txt.close();

        return inputList;
    }
}
