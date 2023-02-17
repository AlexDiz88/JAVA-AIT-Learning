package reader;

import csv.MockCsv;

import java.util.List;

public class CsvReader {

    public static List<String> readFile(String fileName) {
        return MockCsv.CSV_STR;
    }
}
