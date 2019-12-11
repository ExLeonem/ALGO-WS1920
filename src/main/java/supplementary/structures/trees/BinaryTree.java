package supplementary.structures.trees;

/**
 * Binary-Trees can be balance, sorted
 * Conditions Bianry Tree:
 * -
 *
 * @param <T>
 */
public class BinaryTree<T extends Comparable> implements Cloneable {

    // Attributes
    private T currentNodeValue;
    private int weight;
    private BinaryTree<T> parent;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    // Tree constraints
    private boolean balance;
    private boolean order;
    private int balanceLeft; // Number of elements in left
    private int balanceRight;


    public BinaryTree() {
        this.left = null;
        this.right = null;
        this.weight = 0;

        this.order = false;
        this.balance = false;
        this.balanceLeft = 0;
        this.balanceRight = 0;
    }

    public BinaryTree(T currentNodeValue) {
        this.currentNodeValue = currentNodeValue;
        this.left = null;
        this.right = null;
        this.weight = 0;

        this.order = false;
        this.balance = false;
        this.balanceLeft = 0;
        this.balanceRight = 0;
    }

    public BinaryTree(T currentNodeValue, int weight) {
        this.currentNodeValue = currentNodeValue;
        this.left = null;
        this.right = null;
        this.weight = weight;

        this.order = false;
        this.balance = false;
        this.balanceLeft = 0;
        this.balanceRight = 0;
    }

    public BinaryTree(T currentNodeValue, boolean balance, boolean order) {
        this.currentNodeValue = currentNodeValue;
        this.left = null;
        this.right = null;
        this.weight = 0;

        this.order = order;
        this.balance = balance;
        this.balanceLeft = 0;
        this.balanceRight = 0;
    }

    public BinaryTree(T currentNodeValue, int weight, boolean balance, boolean order) {
        this.currentNodeValue = currentNodeValue;
        this.left = null;
        this.right =null;
        this.weight = weight;

        this.order = order;
        this.balance = balance;
        this.balanceLeft = 0;
        this.balanceRight = 0;
    }


    /**
     * Inserts a node into a binary tree.
     *
     * @param item
     */
    public void insert(T item) {

        // Set the current value
        if (this.getCurrentNodeValue() == null) {
            this.setCurrentNodeValue(item);
            return;
        }

        // Get sub-trees
        if (this.toOrder()) {
            this.recurseSingle(item, this);
            return;
        }

        BinaryTree<T> left = this.getLeft();
        BinaryTree<T> right = this.getRight();
        // Update tree
        this.recurseBoth(item, left, right);
    }

    private void recurseInsertSingle(T item, BinaryTree<T> subtree) {



    }


    // Recursive step to insert new value into the tree
    private BinaryTree<T> recurseInsertBoth(T item, BinaryTree<T> left, BinaryTree<T> right) {

        if (left == null && right == null) {
            // insert into left sub tree
            BinaryTree<T> newLeft = new BinaryTree<T>(item);
            this.setLeft(newLeft);
            return null;
        }

        // Either right empty and bigger or values don't need to be in order
        boolean rightNoneEmpty = (this.toOrder() && right.getCurrentNodeValue().compareTo(item) == 1);
        if (left == null && (rightNoneEmpty || !this.toOrder())) {
            left = new BinaryTree<T>(item);
            this.setLeft(left);
            return null;
        }


        return null;
//        this.recurseInsert(item, left)
    }

    // Restructures the tree to
    private void restructure() {

    }


    /**
     * Search for the give item in the binary tree.
     *
     * @param item - to be searched inside the tree.
     * @return true if item exists else false.
     */
    public boolean contains(T item) {

        if (this.toOrder()) {
            // Recurse into single subtree because tree is ordered
            return this.recurseSingle(item, this);
        }

        BinaryTree<T> left = this.getLeft();
        BinaryTree<T> right = this.getRight();
        return this.recurseBoth(item, left, right);
    }

    // Check only a single branch if
    private boolean recurseSingle(T item, BinaryTree<T> subtree) {

        // Can check current subtree
        if (subtree != null && subtree.getCurrentNodeValue().compareTo(item) == 0) {
            return true;
        }

        BinaryTree<T> left = subtree.getLeft();
        BinaryTree<T> right = subtree.getRight();

        // Item may be in left subtree
        if (left != null && (left.getCurrentNodeValue().compareTo(item) == 1 || left.getCurrentNodeValue().compareTo(item) == 0)) {
            return this.recurseSingle(item, left);
        }

        // Item may be in right subtree
        if (right != null && (right.getCurrentNodeValue().compareTo(item) == 1 || right.getCurrentNodeValue().compareTo(item) == 0)) {
            return this.recurseSingle(item, right);
        }

        return false;
    }


    // Recursivly search left and right subtrees because tree is not ordered.
    private boolean recurseBoth(T item, BinaryTree<T> left, BinaryTree<T> right) {

        boolean leftFound = false; // item found in left subtree
        if (left != null) {

            if (left.getCurrentNodeValue().compareTo(item) == 0) {
                return true;
            }

            // Branch out to the left
            BinaryTree<T> leftLeft = left.getLeft();
            BinaryTree<T> rightLeft = left.getRight();
            leftFound = this.recurseBoth(item, leftLeft, rightLeft);
        }

        boolean rightFound = false;
        if (right != null) {

            if (right.getCurrentNodeValue().compareTo(item) == 0) {
                return true;
            }

            // Branch out to the right
            BinaryTree<T> leftRight = right.getLeft();
            BinaryTree<T> rightRight = right.getRight();
            rightFound = this.recurseBoth(item, left, right);
        }

        return leftFound || rightFound;
    }


    /**
     *
     * @param function - takes left and right node as parameter and does something with them
     * @return
     */
    public T reduce(FunctionalInterface function) {

        return null;
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

    public BinaryTree<T> mergeTrees(BinaryTree<T> second) {
        BinaryTree<T> newTree = new BinaryTree<T>();
        return newTree;
    }


    @Override
    public BinaryTree<T> clone() {
        T value = this.getCurrentNodeValue();
        int weight = this.getWeight();
        BinaryTree<T> left = this.getLeft() != null? this.getLeft().clone() : null;
        BinaryTree<T> right = this.getRight() != null? this.getRight().clone() : null;

        boolean balance = this.toBalance();
        boolean order = this.toOrder();

        BinaryTree<T> tree = new BinaryTree<T>(value, weight, balance, order);
        tree.setBalanceLeft(this.getBalanceLeft());
        tree.setBalanceRight(this.getBalanceRight());
        tree.setLeft(left);
        tree.setRight(right);


        return tree;
    }


    // ----------------------
    // Utilities
    // ---------------------


    @Override
    public String toString() {
        return "Node: " + this.getCurrentNodeValue() + "| Weight: " + this.getWeight();
    }




    // ----------------------
    // Setter/-Getter
    // ----------------------

    public void setCurrentNodeValue(T currentNodeValue) {
        this.currentNodeValue = currentNodeValue;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    public void setBalance(boolean balance) {
        this.balance = balance;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    private void setBalanceLeft(int balanceLeft) {
        this.balanceLeft = balanceLeft;
    }

    private void setBalanceRight(int balanceRight) {
        this.balanceRight = balanceRight;
    }

    public T getCurrentNodeValue() {
        return currentNodeValue;
    }

    public int getWeight() {
        return this.weight;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    private boolean toBalance() {
        return balance;
    }

    private boolean toOrder() {
        return order;
    }

    private int getBalanceLeft() {
        return this.balanceLeft;
    }

    private int getBalanceRight() {
        return this.balanceRight;
    }
}
