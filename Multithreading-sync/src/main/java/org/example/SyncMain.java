package org.example;

public class SyncMain {
    final Object lock = new Object();
    final static Object staticLock = new Object();

    public static void main(String[] args) {

    }

    // синхронизация на lock
    public void normalSynchronized() {
        synchronized (lock) {

        }
    }

    // синхронизация на this (на экземпляр класса, от которого вызван метод)
    public void foo() {
        synchronized (this) {

        }
    }

    // синхронизация на this (на экземпляр класса, от которого вызван метод)
    // но синхронизирован весь метод
    public synchronized void bar() {

    }

    // синхронизация на staticLock
    public static void staticFoo() {
        synchronized (staticLock) {

        }
    }

    public static void staticFoo2() {
        synchronized (SyncMain.class) {

        }
    }

    // синхронизация на сам класс
    public static synchronized void staticBar() {
    }

    // может быть ситуация, когда изменение не дошло в другой поток

    private int count = 0;

    public synchronized void add(int value) {
        count += value;
    }

    public synchronized int getCount() {
        return count;
    }

    // volatile спасает от потерянных обновлений переменной
    // volatile НЕ спасает от неатомарных операций
    // используем когда 1 пишет, несколько читает
    // можно использовать для флагов (как interrupted)

    // synchronized спасает от потерянных обновлений переменной
    // synchronized обеспечивает атомарность
    // обеспечивает неодновременный доступ в критическую секцию кода

    // атомики нужны для атомарных операций над примитивами
    // спасает от потерянных обновлений переменной
    // если выбор между "сделать атомарность через synchronized" и java.util.concurrent.atomic
    // то лучше использовать atomic

}
