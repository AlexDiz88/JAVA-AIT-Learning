import java.io.*;
import java.util.ArrayList;

public class FileIO {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Diz\\IdeaProjects\\JAVA Learning\\Utils\\Writer_Reader\\output.txt", true));
            String line = "Hi everybody";
            writer.write(line);
            writer.newLine();
            writer.write(11435);
            writer.newLine();
            writer.write("I'm a programmer\n");
            writer.write("I'm a programmer", 6,3);
            writer.append("\ndwadadada");
            writer.close(); // важно закрыть writer
        } catch (IOException e) {
            e.printStackTrace();
        }
        // reader
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Diz\\IdeaProjects\\JAVA Learning\\Utils\\Writer_Reader\\input.txt"));
//            Если читать по одной строке:
//            String line1 = reader.readLine();
//            System.out.println(line1);
//            reader.skip(2); // пропуск n-символов в файле
//            reader.readLine(); // считывание строки без сохранения = пропуск строки
//            String line2 = reader.readLine();
//            System.out.println(line2);
//            for (String str: reader.)

//            Вывод всех строк из файла
            String line;
            ArrayList<String> lines = new ArrayList<>(); // можно каждую строку добавить в List для дальнейшей работы
            while ((line = reader.readLine()) != null) {
                lines.add(line);
                System.out.println(line);
            }

            reader.close(); // важно закрыть reader
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
