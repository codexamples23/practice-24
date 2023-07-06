### Дженерики и Wildcards

- [прошлый модуль, много текстовых пояснений](../Generics1)

### Стирание типа
- https://javarush.com/groups/posts/2315-stiranie-tipov
- https://habr.com/ru/articles/329550/ (не вникал, но выглядит интересно)


### Лямбды:
1) реализовать метод-"тернарный оператор", по предикату вызывющий либо ifTrue, либо ifFalse:
```java
public static <T, U> Function<T, U> ternaryOperator(
        Predicate<? super T> condition,
        Function<? super T, ? extends U> ifTrue,
        Function<? super T, ? extends U> ifFalse) {

    return null; // тут ваша лямбда
}
```
Пример использования метода:
```java
        Predicate<Integer> condition = num -> num > 0;
        Function<Integer, String> ifTrue = num -> "Positive number";
        Function<Integer, String> ifFalse = num -> "Negative number or zero";
        Function<Integer, String> ternaryFunction = ternaryOperator(condition, ifTrue, ifFalse);
```
[Решение](src/HomeworkSolution.java)

2) с прошлых занятий есть [задачи](../Lambdas/README.md) и [решения](../Lambdas/src/Homework.java)