package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Homework {

    // 1
    public Consumer<String> printStringLambda() {
        return System.out::println;
    }

    // 2
    public Function<String, String> upperCaseLambda() {
        return String::toUpperCase;
    }

    // 3
    public Predicate<Integer> isGreaterThan10Lambda() {
        return number -> number > 10;
    }

    public static void main(String[] args) {
        // 1
        Consumer<String> printStringLambda = (str) -> System.out.println(str);
        printStringLambda.accept("Hello, World!");
        Consumer<String> printStringMethodRef = System.out::println;
        printStringMethodRef.accept("Hello, World!");

        // 2
        Function<String, String> upperCaseLambda = (str) -> str.toUpperCase();
        System.out.println(upperCaseLambda.apply("Hello, World!"));
        Function<String, String> upperCaseMethodRef = String::toUpperCase;
        System.out.println(upperCaseMethodRef.apply("Hello, World!"));

        // 3
        Predicate<Integer> isGreaterThan10Lambda = (num) -> num > 10;
        System.out.println(isGreaterThan10Lambda.test(15));
        Predicate<Integer> isGreaterThan10MethodRef = num -> num > 10;
        System.out.println(isGreaterThan10MethodRef.test(15));

        // 4
        Supplier<Double> randomNumSupplierLambda = () -> Math.random();
        System.out.println(randomNumSupplierLambda.get());
        Supplier<Double> randomNumSupplierMethodRef = Math::random;
        System.out.println(randomNumSupplierMethodRef.get());

        // 5
        Runnable printHelloWorld = () -> System.out.println("Hello, World!");
        printHelloWorld.run();

        // 6
        BiFunction<List<Integer>, Integer, List<Integer>> filterGreaterThan = (list, threshold) -> {
            List<Integer> result = new ArrayList<>();
            for (Integer num : list) {
                if (num > threshold) {
                    result.add(num);
                }
            }
            return result;
        };
        System.out.println(filterGreaterThan.apply(Arrays.asList(1, 11, 21, 5, 15), 10));

        // 7
        Consumer<List<String>> printUpperCaseList = (list) -> {
            for (String str : list) {
                System.out.println(str.toUpperCase());
            }
        };
        // вариант со стримом
//        Consumer<List<String>> printUpperCaseList =
//                list -> list.stream().map(String::toUpperCase).forEach(System.out::println);

        printUpperCaseList.accept(Arrays.asList("one", "two", "three"));

        // 8
        BiFunction<List<Integer>, Integer, Integer> sumGreaterThanNum = (list, threshold) -> {
            int sum = 0;
            for (Integer num : list) {
                if (num > threshold) {
                    sum += num;
                }
            }
            return sum;
        };

        // 9
        Consumer<List<String>> printReverseList = (list) -> {
            for (String str : list) {
                System.out.println(new StringBuilder(str).reverse().toString());
            }
        };
        printReverseList.accept(Arrays.asList("one", "two", "three"));

        // 10
        BiFunction<String, Integer, String> substringFromIndexLambda = (str, index) -> str.substring(index);
        System.out.println(substringFromIndexLambda.apply("Hello, World!", 7));
        BiFunction<String, Integer, String> substringFromIndexMethodRef = String::substring;
        System.out.println(substringFromIndexMethodRef.apply("Hello, World!", 7));

    }
}