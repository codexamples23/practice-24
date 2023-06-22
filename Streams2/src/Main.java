import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6)
        );
        System.out.println(listOfLists);

        Consumer<Integer> consumer = System.out::println;
        Consumer<Integer> consumer2 = x -> System.out.println(x); // вызвать метод, приняв аргумент
        consumer.accept(1); // System.out.println(1);
        consumer2.accept(2);

        List<Integer> listOfNumbers = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        Stream<Integer> stream = listOfLists.stream().flatMap(List::stream);

        Stream<String> streamOfStrings = Stream.of("23", "22", "25");

        System.out.println(listOfNumbers);

        System.out.println(stream.collect(Collectors.averagingInt(Integer::valueOf)));
        System.out.println(streamOfStrings.collect(Collectors.averagingInt(String::length)));

        streamOfStrings = Stream.of("23", "22", "25");
        System.out.println(streamOfStrings.collect(Collectors.summingInt(Integer::parseInt)));

        streamOfStrings = Stream.of("23", "22", "25");
        System.out.println(streamOfStrings.mapToInt(Integer::parseInt).sum());

        // Stream<T>
        // T -> int

        streamOfStrings = Stream.of("d23w", "22", "25");
        IntStream intStream = streamOfStrings.mapToInt(s -> {
            int y = Integer.parseInt(s) / 0;
            return y;
        }); // Stream<String> -> IntStream
        stream = intStream.mapToObj(Integer::valueOf); // IntStream -> Stream<Integer>
        // Без терминальной операции никаких исключений

        System.out.println(Stream.of("Hello", "World", "!").collect(Collectors.joining(" ")));

        System.out.println(groupEven(List.of(1, 2, 3, 4, 5, 6)));

        printFrequentWord(List.of("a", "b", "c", "c", "d"));
        printFrequentWord1(List.of("a", "b", "c", "c", "d"));

    }

    public static Map<Boolean, List<Integer>> groupEven(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.groupingBy(x -> x % 2 == 0));
    }

    // есть список слов, нужно найти самое часто встречающееся слово и вывести его количество
    public static void printFrequentWord(List<String> text) {
        Map<String, Integer> map = new HashMap<>();
        text.stream()
                .forEach(word -> {
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                });

        System.out.println(map.entrySet().stream()
                .sorted((x1, x2) -> x2.getValue() - x1.getValue())
                .findFirst()
                .orElseThrow());

    }

    // есть список слов, нужно найти самое часто встречающееся слово и вывести его количество
    public static void printFrequentWord1(List<String> text) {
        text.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println(entry.getValue()));
    }


}