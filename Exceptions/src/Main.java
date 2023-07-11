import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // считываем число с файла и делим на него
        try {
            exceptionThrower();
        } catch (IOException | ArithmeticException e) {
            System.out.println(e);
            System.out.println(Arrays.toString(
                    e.getStackTrace()
            ));
            System.out.println(e);
            System.out.println(e.getMessage());
        } catch (Throwable t) {

        }
        // zeroDivider(5, 0);
        // nullCaller(null);
        try {
            fileOpener("file");
        } catch (IOException e) {

        }


        // выбросили исключение, между этим и catch попытались закрыть ресурс, поймали исключение и оно подавилось
        try (Res res = new Res()) {
            throw new Exception("main exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (Throwable t: e.getSuppressed()) {
                System.out.println("Suppressed: " + t.getMessage());
            }
        }

        try {
            finallyMethod();
        } catch (RuntimeException re) {
            System.out.println("main");
        }


        try {
            System.exit(127);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally");
        }
    }

    public static void finallyMethod() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("catch");
            throw new RuntimeException();
        } finally {
            System.out.println("Finally after 2 exceptions");
        }
    }

    public static void exceptionThrower() throws Throwable {
        // throw new Exception("exception thrower");
        // checked vs unchecked
        // System.out.println(5 / 0);
        Throwable t = new Exception("throwable");
        throw t;
    }

    public static int zeroDivider(int a, int b) {
        if (b == 0) {
            return Integer.MAX_VALUE;
        }
        return a / b;
    }

    public static void nullCaller(Object object) {
        object.toString();
    }

    public static void fileOpener(String sourceName) throws IOException {
        InputStream inputStream = new FileInputStream(sourceName);
        inputStream.close();
    }

    public static List<Integer> inOrder(TreeNode root) {

        // try-catch работает медленно, если есть возможность проверить условием if
        // то лучше проверить if, не используя try-catch

        List<Integer> result = new LinkedList<>();

        try {
            result.addAll(inOrder(root.left));
        } catch (NullPointerException npe) {

        }
        try {
            result.add(root.value);
        } catch (NullPointerException npe) {

        }
        try {
            result.addAll(inOrder(root.right));
        } catch (NullPointerException npe) {

        }

        return result;
    }



    //        Exception =   проверяемое исключение = checked exception   -> заворачиваете в try-catch
    // RuntimeException = непроверяемое исключение = unchecked exception -> проверяете условие if


    public static void indexException(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//
//        }
        int index = 100500;
        if (index >= arr.length) {
            System.out.println(index);
        }
    }


}