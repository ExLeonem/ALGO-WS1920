package greedy;

import org.junit.jupiter.api.Test;
import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraTest {

    Dijkstra dijk = new Dijkstra();

    @Test
    void linearSimpleTest() {
        Graph graph = new Graph(true);
        Vertex<String> first = new Vertex<String>("1");
        Vertex<String> second = new Vertex<String>("2");
        Vertex<String> third = new Vertex<String>("3");
        Vertex<String> fourth = new Vertex<String>("4");

        graph.addEdge(first, second, 5);
        graph.addEdge(second, third, 10);
        graph.addEdge(second, fourth, 5);

        double actual = dijk.distance(graph, first, third);
        double expected = 15;

        assertEquals(expected, actual);
    }

    @Test
    void singleNode() {
        Graph graph = new Graph(true);
        Vertex<String> first = new Vertex<String>("1");
        graph.addVertex(first);

        double[] actual = dijk.distance(graph, first);
        double[] expected = {0};

        assertArrayEquals(expected, actual, .1);
    }

    @Test
    void multiVertexGraph() {
        Graph graph = new Graph(true);
        Vertex<String> first = new Vertex<String>("0");
        Vertex<String> second = new Vertex<String>("1");
        Vertex<String> third = new Vertex<String>("2");
        Vertex<String> fourth = new Vertex<String>("3");

        graph.addEdge(first, third, 5);
        graph.addEdge(third, second, 2);
        graph.addEdge(second, third, 3);
        graph.addEdge(second, fourth, 8);

        double[] actual = dijk.distance(graph, first);
        double[] expected = {0, 5, 7, 15};

        assertArrayEquals(expected, actual, 0.1);
    }

    @Test
    void cycle() {
        Graph graph = new Graph(true);
        Vertex<String> first = new Vertex<String>("0");
        Vertex<String> second = new Vertex<String>("1");
        Vertex<String> third = new Vertex<String>("2");
        Vertex<String> fourth = new Vertex<String>("3");

        graph.addEdge(first, second, 5);
        graph.addEdge(second, first, 12);
        graph.addEdge(second, third, 8);
        graph.addEdge(third, fourth, 6);
        graph.addEdge(fourth, first, 2);

        double actual = dijk.distance(graph, second, fourth);
        double expected = 14;

        assertEquals(expected, actual);
    }
}
