package org.example;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ParseException {
        LocalDate today = LocalDate.now();
        LocalDate day = today.plusWeeks(1).minusDays(0);

        long daysBetween = ChronoUnit.DAYS.between(today, day);
        System.out.println(daysBetween);

        System.out.println(workingDaysBetween(
                LocalDate.of(2023, 8, 5),
                LocalDate.of(2023, 8, 12))
        );

//        String datetime = "2023-31221321";
//        System.out.println(stringToDateTime(datetime).getDayOfWeek());

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        calendar.add(Calendar.DATE, 31);
        System.out.println(calendar.getTime());

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println(gregorianCalendar.isLeapYear(2000));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(sdf.format(gregorianCalendar.getTime()));
        Date date = sdf.parse("01/08/2023");

        // ситуация, когда НУЖНО передать Function, но вы не хотите изменять объекты с которыми вы работаете
        foo("string", x -> x + x);
        foo("string", Function.identity());
        Collectors.mapping(Function.identity(), Collectors.toList());
        List.of("a", "b", "c").stream().map(Function.identity()).forEach(System.out::println);


    }

    // вычислить кол-во рабочих дней (пн-пт) между датами
    public static long workingDaysBetween(LocalDate start, LocalDate end) {
        return 0;
    }

    // string to data
    public static LocalDateTime stringToDateTime(String datetime) {
        return LocalDateTime.parse(datetime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }




    // не падает, если неправильный формат
    // без try-catch, на регулярных выражениях
    public static LocalDateTime safeConverter(String datetime) {
        return null;
    }

    public static void foo(String x, Function<String, String> function) {
        System.out.println(function.apply(x));
    }
}