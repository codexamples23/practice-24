import java.util.function.Function;
import java.util.function.Predicate;

public class HomeworkSolution {

    public static void main(String[] args) {
        Predicate<Integer> condition = num -> num > 0;
        Function<Integer, String> ifTrue = num -> "Positive number";
        Function<Integer, String> ifFalse = num -> "Negative number or zero";
        Function<Integer, String> ternaryFunction = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(ternaryFunction.apply(5));
        System.out.println(ternaryFunction.apply(0));
        System.out.println(ternaryFunction.apply(-5));

    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }
}
