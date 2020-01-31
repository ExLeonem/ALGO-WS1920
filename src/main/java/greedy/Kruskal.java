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
     * Calculate the minmal spanning tree for a given graph.
     * @param graph - the graph to extract a minimal spanning tree from
     * @return the MST
     */
    public Graph getMST(Graph graph) {

        HashSet<Graph> forest = this.createForest(graph);

        HashSet<Vertex> nodesInUse = new HashSet<Vertex>();
        PriorityQueue<Edge> spanningTreeEdges = new PriorityQueue<Edge>();



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
