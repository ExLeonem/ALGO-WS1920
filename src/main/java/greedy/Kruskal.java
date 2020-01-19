package greedy;

import supplementary.structures.graph.Edge;
import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;

import java.util.*;


/**
 * Kruskal-Algorithm for minimum spanning tree calculation
 *
 * @author Maksim Sandybekov
 * @date 2020-18-1
 */
public class Kruskal {

    /**
     * Calculates the minimal spanning tree for a given graph.
     *
     * @param graph
     * @return
     */
    public Graph getMST(Graph graph) {

        Graph minSpannTree = new Graph();
        HashSet<Vertex> nodesInUse = new HashSet<Vertex>();
        PriorityQueue<Edge> spanningTreeEdges = new PriorityQueue<Edge>();



        return null;
    }


    /**
     * Calculate the minmal spanning tree for a given graph.
     * @param graph - the graph to extract a minimal spanning tree from
     * @param vertex - the vertext to start the extraction from
     * @return the MST
     */
    public Graph getMST(Graph graph, Vertex vertex) {

        HashSet<Graph> forest = this.createForest(graph);



        return null;
    }


    /**
     * Creates a forest of tree with just a single root.
     *
     * @param graph - the base grah
     * @return
     */
    private HashSet<Graph> createForest(Graph graph) {

        Hashtable<Vertex, HashMap<Edge, Edge>> graphRep = graph.getGraphRepresentation();
        HashSet<Graph> forest = new HashSet<Graph>();

        Iterator<Vertex> vertIterator = graphRep.keys().asIterator();
        while (vertIterator.hasNext()) {

            Vertex nextVert = vertIterator.next();
            Graph tree = new Graph();
            tree.addVertex(nextVert);
            forest.add(tree);
        }



        return forest;
    }

}
