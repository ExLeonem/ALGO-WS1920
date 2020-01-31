package greedy;

import org.junit.jupiter.api.Test;
import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;

import static org.junit.Assert.assertArrayEquals;

public class KruskalTest {

    Kruskal kruskal = new Kruskal();


    @Test
    void singleNode() {
        Graph graph = new Graph();
        Vertex onlyNode = new Vertex("1");
        graph.addVertex(onlyNode);

        Graph mst = kruskal.getMST(graph);
        double[][] adjMST = mst.createAdjacencyMatrix();
        double[][] adjCurrent = graph.createAdjacencyMatrix();

        assertArrayEquals(adjCurrent, adjMST);
    }


    @Test
    void twoVertexGraph() {
        Graph graph = new Graph();
        Vertex first = new Vertex("1");
        Vertex second = new Vertex("2");

        graph.addVertices(first, second);
        graph.addEdge(first, second, 1);

        Graph mst = kruskal.getMST(graph);
        double[][] actualAdj = mst.createAdjacencyMatrix();
        double[][] expectedAdj = {{0, 1},{1, 0}};

        assertArrayEquals(expectedAdj, actualAdj);
    }


    @Test
    void graphWithCycles() {
        Graph graph = new Graph();
        Vertex first = new Vertex("1");
        Vertex second = new Vertex("2");
        Vertex third = new Vertex("3");
        Vertex fourth = new Vertex("4");
        Vertex fifth = new Vertex("5");
        Vertex sixth = new Vertex("6");

        graph.addVertices(first, second, third, fourth, fifth, sixth);
        graph.addEdge(first, second, 2);
        graph.addEdge(first, third, 5);
        graph.addEdge(third, second, 12);
        graph.addEdge(third, fifth, 1);
        graph.addEdge(fifth, sixth, 9);
        graph.addEdge(third, sixth, 6);
        graph.addEdge(fourth, first, 2);

        Graph mst = kruskal.getMST(graph);

        double[][] actualAdj = mst.createAdjacencyMatrix();
        double[][] expectedAdj = {
                {0, 2, 2, 5, 0, 0},
                {2, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 1, 6},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 6, 0, 0}
        };

        assertArrayEquals(expectedAdj, actualAdj);
    }

}
