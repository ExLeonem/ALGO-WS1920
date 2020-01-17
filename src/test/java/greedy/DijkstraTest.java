package greedy;

import org.junit.jupiter.api.Test;
import supplementary.structures.graph.Edge;
import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;

import static org.junit.Assert.assertArrayEquals;

public class DijkstraTest {

    Dijkstra dijk = new Dijkstra();

    @Test
    void mutliTest() {
        Graph graph = new Graph(true);
        Vertex<String> first = new Vertex<String>("0");
        Vertex<String> second = new Vertex<String>("1");
        Vertex<String> third = new Vertex<String>("2");
        Vertex<String> fourth = new Vertex<String>("3");

        graph.addEdge(first, third, 5);
        graph.addEdge(third, second, 2);
        graph.addEdge(second, third, 3);
        graph.addEdge(second, fourth, 8);

        double[][] actual = dijk.distance(graph);
        double[][] expected = {{2.0}, {5.0}, {3.0}, {1.0}};

        assertArrayEquals(expected, actual);
    }
}
