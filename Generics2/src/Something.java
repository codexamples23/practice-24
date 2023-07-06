public class Something<T extends Comparable<T>> implements Comparable<Something<T>> {

    @Override
    public int compareTo(Something o) {
        return -2;
    }

    public static <T> int something(T t) {
        System.out.println("something");
        //  return t.compareTo(t);  не работает, т.к. T в статическом методе и T в классе -- разные T
        return 0;
    }
}
