import java.io.*;
import java.util.Arrays;

public class Main {

    private static final byte backslashN = 10;
    private static final byte backslashR = 13;


    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        System.out.println("abcd abbc\r\najjs kfkk kqll\r\nakal dkkkld qlkqkk");
        System.out.println("abcd abbc\najjs kfkk kqll\nakal dkkkld qlkqkk");

        String s = "abcd abbc\r\najjs kf\rkk kqll\r\nakal dkkk\nld qlkqkk";


        File input = new File("input.txt");
        File output = new File("output.txt");

        try (FileOutputStream out = new FileOutputStream(input)) {
            out.write(s.getBytes());
        }

        FileInputStream fin = new FileInputStream(input);
        FileOutputStream fout = new FileOutputStream(output);



        int prevByte = fin.read();
        int nextByte = fin.read();

        while (prevByte != -1) {
            if (prevByte == backslashR && nextByte == backslashN) {
                fout.write(backslashN);
                prevByte = fin.read();
                nextByte = fin.read();
            } else {
                fout.write(prevByte);
                prevByte = nextByte;
                nextByte = fin.read();
            }
        }

        fin.close();
        fout.close();





        File animalFile = new File("animals.bin");

        // ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // ObjectOutputStream oos = new ObjectOutputStream(baos);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(animalFile));

        oos.writeInt(2);
        oos.writeObject(new Animal("Dog"));
        oos.writeObject(new Animal("Cat"));

        oos.close();

        // byte[] byteAnimals = baos.toByteArray();

        Animal[] animals = deserializeAnimalsFromFile(animalFile);
        System.out.println(Arrays.toString(animals));


    }

    /*
65 32 85 99 47 13 10 99

abcd abbc\r\n
ajjs kfkk kqll\r\n
akal dkkkld qlkqkk

читаем байт
если это \r, то читаем следующий байт
если это \n, то НЕ печатаем предыдущий
    */



    /*
    Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
    Массив байт устроен следующим образом. Сначала идет число типа int,
    записанное при помощи ObjectOutputStream.writeInt(size).
    Далее подряд записано указанное количество объектов типа Animal,
    сериализованных при помощи ObjectOutputStream.writeObject(animal).
     */


    public static Animal[] deserializeAnimalArray(byte[] data) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        int size = ois.readInt();

        Animal[] animals = new Animal[size];
        for (int i = 0; i < size; i++) {
            animals[i] = (Animal) ois.readObject();
        }
        ois.close();
        return animals;
    }

    public static Animal[] deserializeAnimalsFromFile(File data) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(data));
        int size = ois.readInt();

        Animal[] animals = new Animal[size];
        for (int i = 0; i < size; i++) {
            animals[i] = (Animal) ois.readObject();
        }
        ois.close();
        return animals;
    }
}