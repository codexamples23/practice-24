public class Node1 {

    private Object data;
    private Node1 next;

    public Node1(Object data, Node1 next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() { return data; }
    // ...
}