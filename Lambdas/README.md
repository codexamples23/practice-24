# Лямбды и ссылки на методы

## Задание

Для каждого из следующих заданий создайте соответствующее лямбда-выражение, а затем перепишите `(1-4, 10)`, используя ссылку на метод:

1. `Consumer` для печати строки.
```java
Consumer<String> printStringLambda = (str) -> System.out.println(str);
printStringLambda.accept("Hello, World!");

Consumer<String> printStringMethodRef = System.out::println;
printStringMethodRef.accept("Hello, World!");
```
2. `Function` для преобразования строки в верхний регистр.
3. `Predicate` для проверки, является ли число больше 10.
4. `Supplier` для генерации случайного числа.
5. `Runnable` для печати "Hello, World!" на консоль.
6. `BiFunction`, которая принимает список чисел и число, и возвращает новый список, который содержит только числа больше данного числа.
7. `Consumer`, который принимает список строк, преобразует их в верхний регистр и печатает.
8. `BiFunction`, которая принимает список чисел и число, и возвращает сумму всех чисел в списке, которые больше данного числа.
9. `Consumer`, который принимает список строк, переворачивает каждую строку и печатает.
10. `BiFunction`, который принимает строку и число, и возвращает подстроку начиная с данного числа.
