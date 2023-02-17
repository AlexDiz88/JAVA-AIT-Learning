import reader.CsvReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String filename = "";
        List<String> csv1 = CsvReader.readFile(filename);
        System.out.println("--------read File---------");
        System.out.println(csv1);
        System.out.println("--------------------------");
        Utils.splitCsv(csv1);

    }
}
