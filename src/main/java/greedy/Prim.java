package greedy;

import supplementary.structures.graph.Edge;
import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;

import java.util.*;

/**
 * Calculate of minimal spanning tree of an undirected Graph.
 *
 * @author Maksim Sandybekov
 * @date 2020-1-18
 */
public class Prim {


    /**
     * Uses a random vertex to calculate the minimum spannig tree.
     *
     * @param graph - the graph to extract the minimum spanning tree.
     * @return the minimum spanning tree
     */
    public Graph getMST(Graph graph) {

        // Stop calculation for directed graph
        if (graph.isDirected()) {
            throw new IllegalArgumentException("Can't calculate a minimum-spanning tree for an directed graph. Choose another algorithm.");
        }

        // Randomly select a vertex
        Random rand = new Random();
        Vertex[] allVertices = graph.getVertices();
        Vertex initVertex = allVertices[rand.nextInt(allVertices.length)];

        return this.getMST(graph, initVertex);
    }


    /**
     * Get the minimum-spanning tree from a given vertex.
     *
     * @param graph - the graph to extract the minimum spanning tree from
     * @param initVertex - the vertex to start at
     * @return
     */
    public Graph getMST(Graph graph, Vertex initVertex) {

        Graph mst = new Graph();
        Vertex[] allVertices = graph.getVertices();

        // Initialize priority queue holding edge in descending order (with minimum-distance at last index)
        LinkedList<Vertex> candidateList = new LinkedList<Vertex>();
        candidateList.add(initVertex);

        // Keep collecting vertices as long as some vertex not included || all vertices visited
        HashSet<Vertex> mstVertixSet = new HashSet<Vertex>(allVertices.length);
        while (!candidateList.isEmpty()) {

            Vertex nextVertex = candidateList.poll();
            if (!mst.contains(nextVertex)) {
                mst.addVertex(nextVertex);
            }

            // Iterate over edges add vertex/edge if non existent
            PriorityQueue<Edge> edges = this.getNeighbours(graph, nextVertex);
            while (!edges.isEmpty()) {

                Edge nextEdge = edges.poll();
                Vertex from = nextEdge.getFromVertex();
                Vertex to = nextEdge.getToVertex();

                if (!mstVertixSet.contains(to)) {
                    candidateList.add(to);
                }

                // Check if one of the already included
                boolean fromIncluded =  mstVertixSet.contains(from);
                boolean toIncluded = mstVertixSet.contains(to);

                Vertex vertToAdd = !fromIncluded ? from : (!toIncluded ? to : null);
                if (!fromIncluded || !toIncluded) {
                    mstVertixSet.add(vertToAdd);
                    mst.addEdge(nextEdge); // adds the non-existent vertex to the graph
                }
            }
        }


        return mst;
    }


    /**
     * Adds new neighbours to the priority queue.
     *
     * @param graph - the graph for which an minimal spannig tree is to be calculated
     * @param vertex
     * @return
     */
    private PriorityQueue<Edge> getNeighbours(Graph graph, Vertex vertex) {

        Hashtable<Vertex, HashMap<Edge, Edge>> edges = graph.getGraphRepresentation();
        HashMap<Edge, Edge> edgeMap = edges.get(vertex);

        Collection<Edge> edgeCollection = edgeMap.values();
        Iterator<Edge> edgeIterator = edgeCollection.iterator();

        PriorityQueue<Edge> edgesToVisit = new PriorityQueue<Edge>();
        // Put all edges from the current node to into priority queue
        while (edgeIterator.hasNext()) {

            Edge nextEdge = edgeIterator.next();
            edgesToVisit.add(nextEdge);
        }

        return edgesToVisit;
    }
}
