package greedy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import supplementary.structures.graph.Graph;
import supplementary.structures.trees.BinaryTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreadthFirstTest {

    @Nested
    class GraphSearchTest {

        BreadthFirst breadth = new BreadthFirst();

        @Test
        void emptyGraph() {
            Graph g = null;
            
        }

    }


    @Nested
    class BinaryTreeSearchTest {

        BreadthFirst<String> breadth = new BreadthFirst<String>();


        @Test
        void emptyTree() {
            BinaryTree<String> tree = null;
            int actual = breadth.search(tree, "h");
            int expected = -1;

            assertEquals(expected, actual);
        }


        @Test
        void emptyElement() {
            BinaryTree<String> tree = new BinaryTree<String>(null);
            int actual = breadth.search(tree, "l");
            int expected = -1;

            assertEquals(expected, actual);
        }


        @Test
        void singleElementNotFound() {
            BinaryTree<String> tree = new BinaryTree<String>("he");
            int actual = breadth.search(tree, "w");
            int expected = -1;

            assertEquals(expected, actual);
        }


        @Test
        void singleElementFound() {
            BinaryTree<String> tree = new BinaryTree<String>("he");
            int actual = breadth.search(tree, "he");
            int expected = 0;

            assertEquals(expected, actual);
        }


        @Test
        void multiDepthDeeper() {

            // Setup
            BinaryTree<String> upperTree = new BinaryTree<String>("Not here");
            upperTree.setRight(new BinaryTree<String>("none"));
            BinaryTree<String> leftSubTree = new BinaryTree<String>("Here?");
            leftSubTree.setLeft(new BinaryTree<String>("what"));
            leftSubTree.setRight(new BinaryTree<String>("here"));
            upperTree.setLeft(leftSubTree);

            int actual = breadth.search(upperTree, "here");
            int expected = 2;

            // Verification
            assertEquals(expected, actual);
        }
    }
}
