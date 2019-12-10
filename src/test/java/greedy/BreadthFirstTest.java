package greedy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import supplementary.structures.graph.Edge;
import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;
import supplementary.structures.trees.BinaryTree;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BreadthFirstTest {

    @Nested
    class GraphSearchTest {


        @Test
        void emptyGraph() {
            Graph g = null;
            BreadthFirst breadth = new BreadthFirst();
            Vertex<String> from = new Vertex<String>("hey");
            Vertex<String> to = new Vertex<String>("he");
            int actual = breadth.search(g, from, to);
            int expected = -1;

            assertEquals(expected, actual);
        }


        @Test
        void singleVertex() {
            Graph g = new Graph();
            Vertex<String> from = new Vertex<String>("he");
            Vertex<String> to = new Vertex<String>("la");
            g.addVertex(from);
            BreadthFirst breadth = new BreadthFirst();
            int actual = breadth.search(g, from, to);
            int expected = -1;

            assertEquals(expected, actual);
        }

        @Test
        void singleEdge() {
            Graph g = new Graph();
            Vertex<String> from = new Vertex<String>("he");
            Vertex<String> to = new Vertex<String>("la");
            g.addVertex(from);
            g.addVertex(to);
            g.addEdge(new Edge(from, to));
            BreadthFirst breadth = new BreadthFirst();
            int actual = breadth.search(g, from, to);
            int expected = 1;


            assertEquals(expected, actual);
        }

        @Test
        void multiEdge() {
            Graph g = new Graph();
            Vertex<String> aVert = new Vertex<String>("he");
            Vertex<String> bVert = new Vertex<String>("la");
            Vertex<String> cVert = new Vertex<String>("ka");
            Vertex<String> hVert = new Vertex<String>("getHere");
            Vertex<String> kVert = new Vertex<String>("some");

            g.addVertices(aVert, bVert, cVert, hVert);
            g.addEdge(new Edge(aVert, bVert));
            g.addEdge(new Edge(bVert, cVert));
            g.addEdge(new Edge(cVert, hVert));
            g.addEdge(new Edge(cVert, kVert));

            BreadthFirst breadth = new BreadthFirst();
            int actual = breadth.search(g, aVert, kVert);
            int expected = 3;

            assertEquals(expected, actual);
        }


        @Test
        void graphWithLoop() {
            Graph g = new Graph(); // undirected graph
            Vertex<String> aVert = new Vertex<String>("he");
            Vertex<String> bVert = new Vertex<String>("la");
            Vertex<String> cVert = new Vertex<String>("ka");

            g.addVertices(aVert, bVert, cVert);
            g.addEdge(new Edge(aVert, bVert));
            g.addEdge(new Edge(bVert, cVert));
            g.addEdge(new Edge(cVert, aVert));

            BreadthFirst breadth = new BreadthFirst();
            int actual = breadth.search(g, aVert, cVert);
            int expected = 1;

            assertEquals(expected, actual);
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
