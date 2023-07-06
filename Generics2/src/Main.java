import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        List list1 = list;
        System.out.println(countNumbers(list, x -> x % 2 == 0));
        System.out.println(max("12", "ab"));
        System.out.println(max(new Something(), new Something()));
        Something.something("abc");

        Node<String> node = new Node<>("node", null); // -> Node node = new Node("node", null);
        Node1 node1 = new Node1("node1", null);

        String data = node.getData(); // -> String data = (String) node.getData();
        String data1 = (String) node1.getData();

        // type erasure
        RunComparable r1 = new RunComparableImpl();
        RunComparable r2 = new RunComparableImpl();
        RunComparable r3 = new RunComparableImpl();
        runMax(r1, r2, r3);

    }


    // нужно написать метод, считающий кол-во элементов в коллекции, удоволетворяющих предикату
    public static <T> int countNumbers(Collection<T> collection, Predicate<T> predicate) {
        int count = 0;
        for (T elem: collection) {
            if (predicate.test(elem)) {
                count++;
            }
        }
        return count;
    }



    public static <T extends Comparable<T>> T max(T x, T y) {
        return x.compareTo(y) > 0 ? x : y;
    }

    // есть массив, нужно обменять местами элементы i, j
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static <T extends Comparable<T>> int findFirstGreaterThan(T[] at, T elem) {
        return 0;
    }

//    public static int findFirstGreaterThan(Comparable[] at, Comparable elem) {
//        return 0;
//    }

    public static void print(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n);

        list.forEach(x -> System.out.print(x + " "));

        System.out.println();
    }

    public static <T extends Runnable & Comparable<T>> void runMax(T a, T b, T c) {
        if (a.compareTo(b) > 0) {
            if (a.compareTo(c) > 0) {
                a.run();
            } else {
                c.run();
            }
        } else {
            if (b.compareTo(c) > 0) {
                b.run();
            } else {
                c.run();
            }
        }


    }





}