package supplementary.structures.trees;

public class Node<T> {

    private T value;
    private Node<T> parentNode;
    private int connectionWeight;

    public Node(T value, int connectionWeight) {
        this.value = value;
        this.connectionWeight = connectionWeight;
    }

    public Node(T value) {
        this.value = value;
        this.connectionWeight = 0;
    }


    // ------------------------
    // Setter/-Getter
    // -----------------------

    public void setValue(T value) {
        this.value = value;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }

    public void setConnectionWeight(int connectionWeight) {
        this.connectionWeight = connectionWeight;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public int getConnectionWeight() {
        return connectionWeight;
    }
}
