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


    /**
     * Performs a breadthsearch on an graph.
     *
     * Greedy-Condition:
     * - Select nearest neighbour that was not visited already
     *
     * @param fromVertex - Vertex from which to start
     * @param toVertex - Destination vertex
     *
     * @return the smallest amount of edges to move over to get to the destination vertex
     */
    public int search(Graph g, Vertex fromVertex, Vertex toVertex) {

        // Can't calculate rank, because at least one is null
        if (g  == null || fromVertex == null || toVertex == null) {
            return -1;
        }

        // Could be rewritten to use adjacency matrix
        HashSet<Vertex> visited = new HashSet<Vertex>();
        LinkedList<Vertex> nextToVisit = new LinkedList<Vertex>();
        nextToVisit.add(fromVertex);

        int rank = 0;
        int childrenCurrentRank = 1; // Keep track of vertices to check currently
        int childrenNextRank = 0; // Keep track of the amount of children added to nextToVisit
        Collection neighbours;
        Vertex vertex;
        while (!nextToVisit.isEmpty()) {

            vertex = nextToVisit.remove();
            childrenCurrentRank--;

            // Vertex was already visited
            visited.add(vertex);

            if (vertex != null && vertex.equals(toVertex)) {
                return rank;
            }

            // Queue further children
            childrenNextRank += this.addNotVisitedVertices(vertex, visited, nextToVisit);

            // Worked through children in current rank, update rank depth and go to next children
            if (childrenCurrentRank == 0) {
                rank++;
                childrenCurrentRank = childrenNextRank;
                childrenNextRank = 0;
            }
        }


        return -1;
    }

    /**
     * Copy vertices not visited already into the linked list & counter number of occurences.
     *
     * @param vertex
     * @param visited
     * @param toVisit
     * @return number of unique vertices.
     */
    private int addNotVisitedVertices(Vertex vertex, HashSet<Vertex> visited, LinkedList<Vertex> toVisit) {

        Iterator<Vertex> vertIterator = vertex.getNeighbours().values().iterator();
        Vertex tmp;
        int countUnique = 0;
        while (vertIterator.hasNext()) {

            tmp = vertIterator.next();

            if (!visited.contains(tmp)) {
                countUnique++;
                toVisit.add(tmp);
            }
        }

        return countUnique;
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
}