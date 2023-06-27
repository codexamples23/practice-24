import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // класс, экземпляр которого мы хотим записать, должен реализовывать интерфейс Serializable
        ObjectInputStream ois;
        ObjectOutputStream oos;



        File file = new File("file1.txt");
        System.out.println(file.createNewFile());

        writeToFile("file1.txt", "hello world!\n");

        printFile("file1.txt");

        FileOutputStream fos = new FileOutputStream("file2.txt"); // если такого файла нет, он будет создан
        fos.write(99);
        fos.close();

        fos = new FileOutputStream("file2.txt", true); // если такого файла нет, он будет создан
        fos.write(100);
        fos.close();

        copyFile("file4.txt", "file3.txt");

        // Unix
        // git bash

    }

    // дан файл, нужно его скопировать в другой файл
    // когда открываете файл на запись, если его нет, он создаётся
    public static void copyFile(String sourceName, String destinationName) {
        try (InputStream inputStream = new FileInputStream(sourceName)) {
            try (OutputStream outputStream = new FileOutputStream(destinationName)) {
                byte[] buffer = new byte[1024];
                int length;
                // считываем сколько-то байт в буффер, записываем в outputStream
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            } catch (IOException e) {

            }
        } catch (IOException e) {

        }
    }




    // открыть файл, записать туда строку
    public static void writeToFile(String filename, String text) {
        // try-with-resources
        // в скобках указываем "ресурс", который открываем

//        BufferedWriter writer = null;
//        try {
//            writer = new BufferedWriter(new FileWriter(filename));
//            writer.write(text);
//        } catch (IOException e) {
//            System.out.println(e.getStackTrace());
//        } finally {
//            try {
//                writer.close();
//            } catch (IOException e) {
//                System.out.println(e.getStackTrace());
//            }
//        }


        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(filename))) {
            writer1.write(text);
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        // writer.close(); не пишем, потому что try-с-ресурсами автоматически закроет наш "ресурс" (поток)
    }


    // открыть файл по имени, считать, вывести содержимое на экран
    public static void printFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        // reader.close();
    }





    // Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
    public static String readStreamToString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Reader reader = new InputStreamReader(inputStream, charset);
        // read читает байт (число 0-255) в int, если нечего читать то -1
        int nextChar;
        while ((nextChar = reader.read()) != -1) {
            stringBuilder.append((char) nextChar);
        }
        return stringBuilder.toString();
    }
}