package supplementary.structures.graph;

import java.util.Hashtable;
import java.util.PriorityQueue;

/**
 * Simple implementation of an directed graph.
 *
 * @author Maksim Sandybekov
 * @date 2019-11-25
 *
 * @param <T> - Vertice type to use.
 * @param <E> - Edge type to use.
 */
public class DirectedGraph<T, E> {

    private Hashtable<T, PriorityQueue<T>> graphRepresentation;


    public DirectedGraph() {
        graphRepresentation = new Hashtable<>();
    }

    // ------------------------------------
    // Basic interaction with the graph
    // ------------------------------------

    public void addVertice(T vertice) {

    }

    public void addEdge(T fromVertice, T toVertice, E edge) {

    }
}
