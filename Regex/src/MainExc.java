import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainExc {
    public static void main(String[] args) {


        countRegex("123", "abc123xyz");

        countRegex("\\.", ".");
        countRegex("\\.", "321321.");
        countRegex("\\.", "dasa.dsa.da");


        // регулярное выражение для разбиения текста на слова


        String s = "Some text abc abc";
        String[] arr = s.split("\\s");
        System.out.println(Arrays.toString(arr));

        // гггг-мм-дд
        // "Сегодня 2023-07-04"

        String regex = "(19|20)[0-9]{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
        String dateString = "Сегодня 2023-07-04 ";
        countRegex(regex, dateString);

        // извлечь первую дату из строки:
        Matcher matcher = Pattern.compile(regex).matcher(dateString);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }

        // номер карты
        // ([0-9]{4}\s){3}[0-9]{4}
        regex = "([0-9]{4}\\s){3}[0-9]{4}";
        String cards = "5105 1051 0510 5100, 4111 1111 1111 1111";
        countRegex(regex, cards);

        matcher = Pattern.compile(regex).matcher(cards);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }










    }

    // посчитать кол-во вхождений регекса в текст
    public static void countRegex(String regex, String text) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        int cnt = 0;
        while (matcher.find()) {
            cnt++;
        }
        System.out.println(cnt);
    }
}
