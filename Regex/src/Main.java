import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) {
        // заменить все e.get...() на "Hello World!"
        System.out.println("Hello world!");
        try {
            Pattern pattern = Pattern.compile("[][");
        } catch (PatternSyntaxException e) {
            System.out.println(e.getPattern());
            System.out.println(e.getIndex());
            // System.out.println(e.getMessage());
        }

        // (0|1)[0-9]{2}
        // [2][0-4]
        //  2[0-4]
        // 20, 21, 22, 23, 24

        String source1 = "Banana        Apple   Orange   Pear";
        String s = source1.replaceAll("\\s+", " ");
        System.out.println(s);


        String textWithGets = "System.out.println(e.getPattern());";
        // мы экранируем в регулярном выражении для того, чтобы БЭКСЛЕШ остался собой
        s = textWithGets.replaceAll("e\\.get\\w+\\(\\)","\"Hello world\"");
        System.out.println(s);

        /*
        строки и экранирование
        "n" -- n
        "\n" -- символ переноса строки
        чтобы получить СТРОКУ \n, нужно экранировать '\'
        "\\n" -- \n
         */

        /*
        e.getPattern()
        e.getIndex()

        просто регулярное выражение, не строка Java, а просто RegEx
        e\.get\w+\(\)


         */
    }
}