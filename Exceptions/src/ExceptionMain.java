public class ExceptionMain {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName()); //  null
        anotherMethod();                                   //  ExceptionMain#main
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod2();
    }

    private static void anotherMethod2() {
        System.out.println(getCallerClassAndMethodName());
    }

    // должен вернуть имя класса и метода, откуда вызван этот метод
    // если метод вызван из точки входа в программу, вернуть null
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        if (stackTrace.length <= 2) {
            return null;
        }
        return String.format("%s#%s", stackTrace[2].getClassName(), stackTrace[2].getMethodName());
    }
}
