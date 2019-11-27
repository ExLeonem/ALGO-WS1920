package greedy;

import supplementary.structures.graph.Edge;
import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;

import java.util.*;

public class BreadthSearch {

    private Graph graph;
    private int lastPath;

    public BreadthSearch(Graph graph) {
        this.graph = graph;
        this.lastPath = 0;
    }

    /**
     * Performs a breadthsearch on an graph.
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