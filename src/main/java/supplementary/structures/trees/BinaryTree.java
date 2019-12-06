package supplementary.structures.trees;

/**
 * Conditions Bianry Tree:
 * - left side tree only values smaller then parent
 *
 * @param <T>
 */
public class BinaryTree<T extends ArithmeticOperation & Comparable> {

    private Node currentNode;
    private BinaryTree left;
    private BinaryTree right;


    public BinaryTree() {
        this.left = null;
        this.right = null;
    }


    public BinaryTree() {

    }



    public BinaryTree(Node left, Node right) {
        this.left = left;
        this.right = right;
    }



    // insert a generic item into the binary tree
    public void insert(T item) {

    }

    public void insert(int value) {

    }

    /**
     *
     * @param function - takes left and right node as parameter and does something with them
     * @return
     */
    public T reduce(FunctionalInterface function) {

    }


    /**
     * Inserts the new value at the top of the binary tree
     *
     * @param value
     */
    public void insertAtTop(T value) {

        Node<T> newParentNode = new Node<T>(value);

        //
        if (this.getLeft() != null && this.getRight() != null) {

        }
    }


    // ----------------------
    // Setter/-Getter
    // ----------------------

    public void setLeft(Node<BinaryTree> left) {
        this.left = left;
    }

    public void setRight(Node<BinaryTree> right) {
        this.right = right;
    }

    public BinaryTree getLeftChild() {
        return this.left.getValue();
    }

    public BinaryTree getRightChild() {
        return this.right.getValue();
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

}
