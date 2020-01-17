package greedy;


import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;

import java.util.Arrays;
import java.util.LinkedList;

public class Dijkstra {


    private double[][] distanceMatrix;

    public Dijkstra(){}


    /**
     * Calculates the distance between
     * @param graph
     * @param start
     * @param end
     * @return
     */
    public Vertex[] distance(Graph graph, Vertex start, Vertex end) {

        //Calculate the distances between every node
        double[][] distanceMatrix = this.distance(graph);

        // Identify minimal distance between nodes

        return new Vertex[2];
    }


    /**
     * Calculate the distance the minimal distance between all vertices in a graph.
     *
     * @param graph -
     * @return
     */
    public double[][] distance(Graph graph) {

        //
        double[][] adjMatrix = graph.createAdjacencyMatrix();
        double[][] distanceMatrix = this.initDistanceMatrix(adjMatrix);



        return distanceMatrix;
    }


    /**
     * Initializes a matrix representing the
     * @param adjMatrix
     * @return
     */
    private double[][] initDistanceMatrix(double[][] adjMatrix) {

        double[][] distanceMatrix = new double[adjMatrix.length][adjMatrix[0].length];
        for (int i = 0; i < distanceMatrix.length; i++) {

            for (int j = 0; j < distanceMatrix[i].length; j++) {

                if (i == 0) {
                    distanceMatrix[i][j] = adjMatrix[i][j];
                    continue;
                }

                distanceMatrix[i][j] = Double.MAX_VALUE;
            }
        }

        return distanceMatrix;
    }

    // -----------------
    // Setter/-Getter
    // --------------------

    public void setDistanceMatrix(double[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    public double[][] getDistanceMatrix() {
        return this.distanceMatrix;
    }

}
