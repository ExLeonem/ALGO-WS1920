package supplementary.structures.tree;

import org.junit.jupiter.api.Test;
import supplementary.structures.trees.BinaryTree;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BinaryTreeTest {

    @Test
    void insertionTest() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(10);

        int actual = tree.getCurrentNodeValue();
        assertEquals(10, actual);
    }


    @Test
    void searchTest() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(20);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);

        boolean actual = tree.contains(10);
        assertEquals(true, actual);
    }


    @Test
    void removeElement() {

    }
}
