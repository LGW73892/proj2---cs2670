/**
 * this class stores infromation in a node with info and the next node
 */
public class NodeType<T extends Comparable<T>> {

    public T info;
    public NodeType<T> next;
    public NodeType<T> back;

    public NodeType(T info) {

        this.info = info;
        this.next = null;
        this.back = null;

    }

}
