package org.example;

public class SyncMain {
    final Object lock = new Object();
    final static Object staticLock = new Object();

    public static void main(String[] args) {

    }

    public void foo() {
        synchronized (this) {

        }
    }

    public synchronized void bar() {

    }

    public static void staticFoo() {
        synchronized (staticLock) {

        }
    }

    public static void staticFoo2() {
        synchronized (SyncMain.class) {

        }
    }

    public static synchronized void staticBar() {
    }

}
