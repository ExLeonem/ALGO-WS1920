package supplementary.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import supplementary.structures.graph.Edge;
import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


public class GraphTest {

    @Test
    @DisplayName("Test adding vertices and retrieving saved vertices.")
    void addVerticeOperation() {
        Graph graph = new Graph();
        Vertex<String> vertexA = new Vertex<String>("Vertex A");
        Vertex<String> vertexB = new Vertex<String>("Vertex B");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        Vertex<String>[] vertices = graph.getVertices();
        Vertex<String>[] actualVertices = new Vertex[]{vertexA, vertexB};

        assertTrue(Arrays.deepEquals(vertices, actualVertices));
    }


    @Test
    @DisplayName("Test adding negative")
    void addVerticeOperationNegative() {
        Graph graph = new Graph();
        Vertex<String> vertexA = new Vertex<String>("Vertex A");
        Vertex<String> vertexB = new Vertex<String>("Vertex B");
        Vertex<String> vertexC = new Vertex<String>("Vertex C");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        Vertex<String>[] vertices = graph.getVertices();
        Vertex<String>[] actualVertices = new Vertex[]{vertexA, vertexC};

        assertTrue(!Arrays.deepEquals(vertices, actualVertices));
    }


    @Test
    @DisplayName("Test adding an edge and retrieving it's value")
    void addEdgeOperation() {
        Graph graph = new Graph();
        Vertex<String> vertexA = new Vertex<String>("Vertex A");
        Vertex<String> vertexB = new Vertex<String>("Vertex B");
        Edge edge = new Edge(vertexA, vertexB, 12);

        graph.addVertex(vertexA);
        graph.addEdge(edge);

        assertEquals(graph.getEdge(vertexA, vertexB), 12);
    }


    @Test
    void addMultiEdgeOperation() {
        Graph graph = new Graph();
        Vertex<String> vertexA = new Vertex<String>("A");
        Vertex<String> vertexB = new Vertex<String>("B");
        Vertex<String> vertexC = new Vertex<String>("C");

        Edge edgeAB = new Edge(vertexA, vertexB, 5);
        Edge edgeAC = new Edge(vertexA, vertexC, 15);
        graph.addVertex(vertexA);
        graph.addEdge(edgeAB);
        graph.addEdge(edgeAC);

    }


    @Test
    @DisplayName("Check if the directed flag of the graph structure holds true.")
    void checkDirectedFlag() {
        Graph graph = new Graph();
        Vertex<String> vertexA = new Vertex<String>("Vertex A");
        Vertex<String> vertexB = new Vertex<String>("Vertex B");
        Edge edge = new Edge(vertexA, vertexB, 12);

        graph.addVertex(vertexA);
        graph.addEdge(edge);

        assertEquals(graph.getEdge(vertexB, vertexA), 12);
    }


    @Test
    void checkAdjacencyUndirected() {
        Graph graph = new Graph();
        Vertex<String> vertexA = new Vertex<String>("A");
        Vertex<String> vertexB = new Vertex<String>("B");
        Vertex<String> vertexC = new Vertex<String>("C");

        Edge edgeAB = new Edge(vertexA, vertexB, 5);
        Edge edgeAC = new Edge(vertexA, vertexC, 15);
        graph.addVertex(vertexA);
        graph.addEdge(edgeAB);
        graph.addEdge(edgeAC);

        double[][] adjacencyMatrix = graph.createAdjacencyMatrix();
        double[][] actual = new double[][]{{0,5,15}, {5,0,0}, {15,0,0}};

        assertArrayEquals(adjacencyMatrix, actual);
    }


    @Test
    void checkAdjacencyDirected() {
        Graph graph = new Graph(true);
        Vertex<String> vertexA = new Vertex<String>("A");
        Vertex<String> vertexB = new Vertex<String>("B");
        Vertex<String> vertexC = new Vertex<String>("C");

        Edge edgeAB = new Edge(vertexA, vertexB, 5);
        Edge edgeAC = new Edge(vertexA, vertexC, 15);
        graph.addVertex(vertexA);
        graph.addEdge(edgeAB);
        graph.addEdge(edgeAC);

        double[][] adjacencyMatrix = graph.createAdjacencyMatrix();
        double[][] actual = new double[][]{{0,5,15}, {0,0,0}, {0,0,0}};

        assertArrayEquals(adjacencyMatrix, actual);
    }

}
