package supplementary.structures.graph;

import java.util.*;


/**
 * TODO: Identical edges not checked
 */

/**
 * Implementation of a simple graph structure.
 * If set to false the directed attribute adds an additional edge to keep the graph undirected.
 *
 * @author Maksim Sandybekov
 * @date 2019-11-25
 */
public class Graph {


    private Hashtable<Vertex, HashMap<Edge, Edge>> graphRepresentation;
    private LinkedHashMap<Vertex, Integer> vertexMap; // Should be replaced with LinkedList (Integer is index of the vertex, that is used for adjacency matrix generation)
    private double[][] adjacencyMatrix;
    private boolean directed; // is Graph directed, no loops?
    private boolean reGenerate; // adjacency matrix needs to be recalculated
    private int vertexCounter;


    public Graph() {
        this.graphRepresentation = new Hashtable<Vertex, HashMap<Edge, Edge>>();
        this.directed = false;
        this.reGenerate = true;
        this.vertexMap = new LinkedHashMap<Vertex, Integer>();
        this.vertexCounter = 0;
    }

    public Graph(boolean directed) {
        this.graphRepresentation = new Hashtable<Vertex, HashMap<Edge, Edge>>();
        this.directed = directed;
        this.reGenerate = true;
        this.vertexMap = new LinkedHashMap<Vertex, Integer>();
        this.vertexCounter = 0;
    }


    // --------------------------------
    // Basic graph operations
    // --------------------------------

    /**
     * Adding a new Vertexs to the graph structure.
     *
     * @param vertex - vertex to add.
     */
    public void addVertex(Vertex vertex) {
        Hashtable<Vertex, HashMap<Edge, Edge>> graphRepresentation = this.getGraphRepresentation();

        // Exit method if vertex already exists
        boolean vertexAlreadyExists = graphRepresentation.contains(vertex);
        if (vertexAlreadyExists) {
            return;
        }

        // Add a new vertice to the table
        HashMap<Edge, Edge> edgeSet = new HashMap<Edge, Edge>();
        graphRepresentation.put(vertex, edgeSet);
    }


    /**
     * Add multiple vertices at once to the current graph.
     *
     * @param vertices
     */
    public void addVertices(Vertex ...vertices) {
        for (Vertex vertex : vertices) {
            this.addVertex(vertex);
        }
    }


    /**
     * Add an edge between two vertices of an graph.
     *
     * @param edge - edge between two vertices.
     */
    public void addEdge(Edge edge) {

        Vertex fromVertex = edge.getFromVertex();
        Vertex toVertex = edge.getToVertex();

        Hashtable<Vertex, HashMap<Edge, Edge>> table = this.getGraphRepresentation();
        HashMap<Edge, Edge> edgeSet = table.get(fromVertex);
        edgeSet.put(edge, edge);

        // Track every used vertex
        this.updateVertexSet(fromVertex);
        this.updateVertexSet(toVertex);

        // Additional insertes for undirected graphs
        boolean undirected = !this.isDirected();
        if (undirected) {
            boolean toVerticeExists = table.contains(toVertex);

            // Add non existing vertice
            if (!toVerticeExists) {
                table.put(toVertex, new HashMap<Edge, Edge>());
            }

            // Append the reversed edge
            double value = edge.getValue();
            HashMap<Edge, Edge> toEdgeMap = table.get(toVertex);
            Edge reversedEdge = new Edge(toVertex, fromVertex, value);
            toEdgeMap.put(reversedEdge, reversedEdge);
        }
    }


    /**
     * Get's an direct edge between two vertices if it is existent.
     *
     * @param fromVertex - start vertex.
     * @param toVertex - end vertex
     * @return - the edge between two vertices.
     */
    public double getEdge(Vertex fromVertex, Vertex toVertex) {
        Hashtable<Vertex, HashMap<Edge, Edge>> table = this.getGraphRepresentation();
        HashMap<Edge, Edge> edgeMap = table.get(fromVertex);

        // Key not-existing
        if (edgeMap == null) {
            throw new NullPointerException("There is no edge between these two vertices.");
        }

        // Search for edge with destination vertex
        Collection<Edge> edges = edgeMap.values();
        Iterator<Edge> edgeIterator = edges.iterator();
        while(edgeIterator.hasNext()) {
            Edge edge = edgeIterator.next();
            if (edge.getToVertex().equals(toVertex)) {
                return edge.getValue();
            }
        }

        // Destinatinon vertex not found in priority list
        throw new NullPointerException("There's no edge between these two vertices.");
    }


    // --------------------------------
    // Utility functions
    // --------------------------------

    /**
     * Uses the graph definition to generate an adjacency matrix.
     *
     * @return - the graph defined as adjacency matrix.
     */
    public double[][] createAdjacencyMatrix() {

        LinkedHashMap<Vertex, Integer> allVertices = this.getVertexMap();

        int numVertices = allVertices.size();
        double[][] adjMatrix = new double[numVertices][numVertices];

        Hashtable<Vertex, HashMap<Edge, Edge>> graph = this.getGraphRepresentation();
        Enumeration<Vertex> vertexEnum = graph.keys();

        // Fill adjacency matrix
        Iterator<Vertex> vertexIterator = vertexEnum.asIterator();
        Vertex fromVertex;
        Vertex toVertex;
        Edge currentEdge;
        int verticalIndx = 0;
        int horizontalIndx = 0;
        while (vertexIterator.hasNext()) {
            fromVertex = vertexIterator.next();
            verticalIndx = allVertices.get(fromVertex);

            // Iterate over edges
            HashMap<Edge, Edge> edgeMap = graph.get(fromVertex);
            Collection<Edge> edges = edgeMap.values();
            Iterator<Edge> edgeIterator = edges.iterator();
            while(edgeIterator.hasNext()) {
                currentEdge = edgeIterator.next();
                toVertex = currentEdge.getToVertex();
                horizontalIndx = allVertices.get(toVertex);
                double value = currentEdge.getValue();

                adjMatrix[verticalIndx][horizontalIndx] = value;
            }
        }

        return adjMatrix;
    }


    /**
     * Keep a list of unique vertices used inside the graph.
     *
     * @param vertex
     */
    private void updateVertexSet(Vertex vertex) {
        LinkedHashMap<Vertex, Integer> vertexMap = this.getVertexMap();
        int vertexCounter = this.getVertexCounter();
        if (vertexMap.get(vertex) == null) {
            vertexMap.put(vertex, vertexCounter++);
            this.setVertexCounter(vertexCounter);
        }
    }

    /**
     *
     * @return - An array of vertices used in the graph.
     */
    public Vertex[] getVertices() {
        Hashtable<Vertex, HashMap<Edge, Edge>> table = this.getGraphRepresentation();
        Enumeration<Vertex> verticeEnum = table.keys();
        Iterator<Vertex> verticeIt = verticeEnum.asIterator();

        List<Vertex> verticeList = new ArrayList<Vertex>();
        verticeIt.forEachRemaining(verticeList::add);

        Vertex[] vertices = new Vertex[verticeList.size()];
        vertices = verticeList.toArray(vertices);

        return vertices;
    }


    /**
     *
     * @param vertex
     * @return HashMap of Edges.
     */
    public HashMap<Edge, Edge> getEdgeMap(Vertex vertex) {
        Hashtable<Vertex, HashMap<Edge, Edge>> table = this.getGraphRepresentation();

        if (table.contains(vertex)) {
            return table.get(vertex);
        }
        return null;
    }


    // ----------------------------------
    // Setter/-Getter
    // ----------------------------------


    public void setGraphRepresentation(Hashtable<Vertex, HashMap<Edge, Edge>> graphRepresentation) {
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

    public void setVertexmap(LinkedHashMap<Vertex, Integer> vertexMap) {
        this.vertexMap = vertexMap;
    }

    public void setVertexCounter(int vertexCounter) {
        this.vertexCounter = vertexCounter;
    }

    public Hashtable<Vertex, HashMap<Edge, Edge>> getGraphRepresentation() {
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

    public Comparator<Edge> getDefaultComparator() {
        return new Comparator<Edge>(){
            @Override
            public int compare(Edge first, Edge second) {

                double firstValue = first.getValue();
                double secondValue = second.getValue();

                return firstValue < secondValue? -1 : 1;
            }
        };
    }

    public LinkedHashMap<Vertex, Integer> getVertexMap() {
        return this.vertexMap;
    }

    public int getVertexCounter() {
        return this.vertexCounter;
    }
}
