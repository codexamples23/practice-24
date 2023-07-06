// <T extends Number & Comparable<? super T>>
public class SomethingElse extends Number implements Comparable<Number> {

    @Override
    public int compareTo(Number o) {
        return 0;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
