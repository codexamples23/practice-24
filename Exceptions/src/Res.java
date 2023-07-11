public class Res implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("auto closeable");
    }
}
