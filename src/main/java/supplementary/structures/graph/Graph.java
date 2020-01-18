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
    private int edgeCounter;

    private Vertex[] adjacencyAccessor; // After creation of adjacency matrix, index of column/row represents vertex at index in this array


    public Graph() {
        this.graphRepresentation = new Hashtable<Vertex, HashMap<Edge, Edge>>();
        this.directed = false;
        this.reGenerate = true;
        this.vertexMap = new LinkedHashMap<Vertex, Integer>();
        this.vertexCounter = 0;
        this.edgeCounter = 0;
    }

    public Graph(boolean directed) {
        this.graphRepresentation = new Hashtable<Vertex, HashMap<Edge, Edge>>();
        this.directed = directed;
        this.reGenerate = true;
        this.vertexMap = new LinkedHashMap<Vertex, Integer>();
        this.vertexCounter = 0;
        this.edgeCounter = 0;
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
        boolean vertexAlreadyExists = graphRepresentation.containsKey(vertex);
        if (vertexAlreadyExists) {
            return;
        }

        // Add a new vertice to the table
        HashMap<Edge, Edge> edgeSet = new HashMap<Edge, Edge>();
        graphRepresentation.put(vertex, edgeSet);

        // Update currently used vertices in graph
        this.updateVertexSet(vertex);
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
     * Adds an edge from/to given vertices.
     *
     * @param from
     * @param to
     */
    public void addEdge(Vertex from, Vertex to, int weight) {

        boolean isDirected = this.isDirected();

        // Add Edge
        Edge edge = new Edge(from, to, weight);
        this.addEdge(edge);
    }


    /**
     * Add a single edge between two vertices of an graph.
     *
     * @param edge - edge between two vertices.
     */
    public void addEdge(Edge edge) {

        boolean undirected = !this.isDirected();
        Vertex fromVertex = edge.getFromVertex();
        Vertex toVertex = edge.getToVertex();

        this.addVertex(fromVertex);
        this.addVertex(toVertex);

        // Add neighbours
        fromVertex.addNeighbour(toVertex);
        if (undirected) {
            toVertex.addNeighbour(fromVertex);
        }

        // Update
        this.updateVertexSet(fromVertex);
        this.updateVertexSet(toVertex);

        Hashtable<Vertex, HashMap<Edge, Edge>> table = this.getGraphRepresentation();
        HashMap<Edge, Edge> edgeSet = table.get(fromVertex);
        edgeSet.put(edge, edge);
//        System.out.println(edge.toString());

        // Additional insertes for undirected graphs
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

        this.edgeCounter += 1;
    }

    /**
     * Add multiple edges at onece. Interanlly calls the addEdge Method multiple times.
     * @param edges - the edges to add
     */
    public void addEdges(Edge ...edges) {

        for (Edge edge: edges) {
            this.addEdge(edge);
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
        Vertex[] adjAccessor = new Vertex[numVertices];

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

            // Set keymap for mapping between vertex <> indx
            if (adjAccessor[verticalIndx] == null) {
                adjAccessor[verticalIndx] = fromVertex;
            }

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

        this.adjacencyAccessor = adjAccessor;
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
            this.vertexCounter = vertexCounter;
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


    /**
     * Prints the current adjacency matrix
     */
    public void print() {
        double[][] adjMatrix = this.createAdjacencyMatrix();

        // Print a header (The nodes from which to start
        System.out.print("| From/To |||");
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.print(i + " |");
        }
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 0; i < adjMatrix.length; i++) {

            System.out.print("| " + i + " |||");
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print( " " + adjMatrix[i][j] + " |");
            }

            System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }



    // ----------------------------------
    // Setter/-Getter
    // ----------------------------------

    public Hashtable<Vertex, HashMap<Edge, Edge>> getGraphRepresentation() {
        return graphRepresentation;
    }


    public boolean isDirected() {
        return directed;
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

    public int getEdgeCounter() {
        return this.edgeCounter;
    }
}
