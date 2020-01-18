package greedy;

import supplementary.structures.graph.Edge;
import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;

public class Prim {


    public Graph calculate(Graph graph) {

        Graph mst = new Graph();
        PriorityQueue<Edge> edgesToVisit = new PriorityQueue<Edge>();

        // Select a random
        Random rand = new Random();
        Vertex[] availableVertices = graph.getVertices();



        while (!edgesToVisit.isEmpty()) {


        }


        return mst;
    }
}
