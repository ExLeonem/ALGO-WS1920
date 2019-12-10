package greedy;

import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;
import supplementary.structures.trees.BinaryTree;
import java.util.*;

/**
 *
 * @author Maksim Sandybekov
 * @date 2019-12-10
 *
 * @param <T> - element to look out for in binary tree. As binary tree itself is generic
 */
public class BreadthFirst<T extends Comparable> {

    private Graph graph;
    private int lastPath;

    public BreadthFirst() {}
    public BreadthFirst(Graph graph) {
        this.graph = graph;
        this.lastPath = 0;
    }


    /**
     * Performs a breadthsearch on an graph.
     *
     * Greedy-Condition:
     * - Select nearest neighbours
     *
     * @param fromVertex - Vertex from which to start
     * @param toVertex - Destination vertex
     *
     * @return the smallest amount of edges to move over to get to the destination vertex
     */
    public int search(Vertex fromVertex, Vertex toVertex) {

        HashMap<Vertex, Vertex> neighbours = fromVertex.getNeighbours();

        HashSet<Vertex> visited = new HashSet<Vertex>();
        LinkedList<Vertex> puffer = new LinkedList<Vertex>();

        int rank = 0;
        int childrenNextRank = 0; // Keeps track of the amount of children to check in nextRank

//        HashMap<Edge, Edge> edgeMap = graphRepresentation.get(fromVertex);
//        Collection<Edge> edgeCol = edgeMap.values();
//        Iterator<Edge> edgeIterator = edgeCol.iterator();
//        edgeIterator.
//        int toCheck = edgeCol.size();
//        while (edgeIterator.hasNext()) {
//
//
//        }


        return this.getLastPath();
    }


    /**
     * Looks for specific element in the binary tree and returns the depth in which it was found or else -1.
     *
     * @param tree - tree to look through
     * @param toLookFor - from generic element
     * @return the depth in which the element was found or -1 if element not found
     */
    public int search(BinaryTree tree, T toLookFor) {

        // Edge case null pointer passed to function
        if (tree == null) {
            return -1;
        }

        LinkedList<BinaryTree<T>> subTreeQueue = new LinkedList<BinaryTree<T>>();
        subTreeQueue.add(tree);

        BinaryTree<T> tmpSubTree;
        BinaryTree<T> left;
        BinaryTree<T> right;
        int depth = 0;
        int elementsAtLevel = 1;
        int childrenAdded = 0; // Keep track of children added at current depth

        while(!subTreeQueue.isEmpty()) {
            tmpSubTree = subTreeQueue.remove();
            elementsAtLevel--; // Reduce amount of elements at current level

            T currentNodeValue = tmpSubTree.getCurrentNodeValue();
            if (currentNodeValue != null && tmpSubTree.getCurrentNodeValue().equals(toLookFor)) {
                return depth;
            }

            // Append children if non-empty
            left = tmpSubTree.getLeft();
            if (left != null) {
                subTreeQueue.add(left);
                childrenAdded++;
            }

            right = tmpSubTree.getRight();
            if (right != null) {
                subTreeQueue.add(right);
                childrenAdded++;
            }

            // All elements at current level checkd, go one level deeper
            if (elementsAtLevel == 0) {
                depth++;
                elementsAtLevel = childrenAdded; // Check the next n-elements at next depth
                childrenAdded = 0; //
            }
        }


        return -1; // element not found
    }


    // ---------------------------
    // Setter/-Getter
    // ---------------------------

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void setLastPath(int lastPath) {
        this.lastPath = lastPath;
    }

    public Graph getGraph() {
        return graph;
    }

    public int getLastPath() {
        return lastPath;
    }
}