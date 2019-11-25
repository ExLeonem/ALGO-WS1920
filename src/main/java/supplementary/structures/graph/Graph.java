package supplementary.structures.graph;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;

/**
 * Implementation of a simple graph structure.
 *
 * @author Maksim Sandybekov
 * @date 2019-11-25
 */
public class Graph {

    private Hashtable<Vertice, PriorityQueue<Edge>> graphRepresentation;
    private double[][] adjacencyMatrix;
    private boolean directed;
    private boolean reGenerate; // adjacency matrix needs to be recalculated
    private Comparator<Edge> comparator;

    public Graph(boolean directed) {
        graphRepresentation = new Hashtable<Vertice, PriorityQueue<Edge>>();
        this.directed = directed;
        this.reGenerate = true;
        this.comparator = new Comparator<Edge>(){
            @Override
            public int compare(Edge first, Edge second) {

                double firstValue = first.getValue();
                double secondValue = second.getValue();

                return firstValue < secondValue? -1 : 1;
            }
        };
    }


    // --------------------------------
    // Basic graph operations
    // --------------------------------

    /**
     * Adding a new vertices to the graph structure.
     *
     * @param vertice
     */
    public void addVertice(Vertice vertice) {
        Hashtable<Vertice, PriorityQueue<Edge>> graphRepresentation = this.getGraphRepresentation();

        // Exit method if vertice already existts
        boolean verticeAlreadyExists = graphRepresentation.contains(vertice);
        if (verticeAlreadyExists) {
            return;
        }

        // Add a new vertice to the table
        Comparator<Edge> comparator = this.getComparator();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(comparator);
        graphRepresentation.put(vertice, priorityQueue);
    }

    /**
     * Add an edge between two vertices of an graph.
     *
     * @param edge
     */
    public void addEdge(Edge edge) {
        Hashtable<Vertice, PriorityQueue<Edge>> table = this.getGraphRepresentation();

        Vertice fromVertice = edge.getFromVertice();
        Vertice toVertice = edge.getFromVertice();

        PriorityQueue priorityQueue = table.get(fromVertice);
        priorityQueue.add(edge);

        // Undirected graphs need to track the other direction also
        boolean undirected = !this.isDirected();
        if (undirected) {
            boolean toVerticeExists = table.contains(toVertice);
            if (!toVerticeExists) {
                // Add non existing vertice

            }
        }

    }


    // --------------------------------
    // Utility functions
    // --------------------------------


    /**
     * Uses the graph definition to generate an adjancency matrix.
     *
     * @return - the graph defined as adjacency matrix.
     */
    public double[][] getAdjancencyMatrix() {

        return new double[][]{{1.0}};
    }


    // ----------------------------------
    // Setter/-Getter
    // ----------------------------------


    public void setGraphRepresentation(Hashtable<Vertice, PriorityQueue<Edge>> graphRepresentation) {
        this.graphRepresentation = graphRepresentation;
    }

    public void setAdjacencyMatrix(double[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public void setReGenerate(boolean reGenerate) {
        this.reGenerate = reGenerate;
    }

    public void setComparator(Comparator<Edge> comparator) {
        this.comparator = comparator;
    }

    public Hashtable<Vertice, PriorityQueue<Edge>> getGraphRepresentation() {
        return graphRepresentation;
    }

    public double[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public boolean isDirected() {
        return directed;
    }

    public boolean isReGenerate() {
        return reGenerate;
    }

    public Comparator<Edge> getComparator() {
        return this.comparator;
    }
}
