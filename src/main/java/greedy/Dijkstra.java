package greedy;


import supplementary.structures.graph.Graph;
import supplementary.structures.graph.Vertex;
import supplementary.utils.ArrayUtils;

import java.util.*;

public class Dijkstra {


    private double[][] distanceMatrix;

    public Dijkstra(){}


    /**
     * Calculates the distance between start and end-node.
     *
     * @param graph - the graph
     * @param start - start vertex
     * @param end - end vertex
     * @return the distance between the vertices of the graph
     */
    public double distance(Graph graph, Vertex start, Vertex end) {

        //Calculate the distances between every node
        HashMap<Vertex, Integer> vertMap = graph.getVertexMap();

        double[] distances = this.distance(graph, start);
        Integer vertIndx = vertMap.get(end);

        if (vertIndx == null) {
            throw new IllegalArgumentException("Given Vertex: " + end + " is not part of the Graph.");
        }

        return distances[vertIndx];
    }


    /**
     * Calculate the distance the minimal distance between all vertices in a graph.
     *
     * @param graph -
     * @return
     */
    public double[] distance(Graph graph, Vertex start) {

        // Get indx of the starting vertex
        HashMap<Vertex, Integer> vertMap = graph.getVertexMap();
        Integer startIndx = vertMap.get(start);
        if (startIndx == null) {
            throw new IllegalArgumentException("Start Vertex: " + start.toString() + " can't be found in the graph.");
        }

        double[][] adjMatrix = graph.createAdjacencyMatrix();

        int startVert = startIndx.intValue();
        PriorityQueue<NextVertex> toVisit = new PriorityQueue<NextVertex>(new Comparator<NextVertex>() {
            @Override
            public int compare(NextVertex o1, NextVertex o2) {
                if (o1.getCost() < o2.getCost()) {
                    return -1;
                } else if (o1.getCost() == o2.getCost()) {
                    return 0;
                }

                return 1;
            }
        });
        toVisit.add(new NextVertex(startVert, 0));

        // Initializes distances
        double[] distances = Arrays.stream(new double[vertMap.size()]).map(x -> x + Double.MAX_VALUE).toArray(); // Set all values to infinity
        while (!toVisit.isEmpty()) {

            NextVertex currentVert = toVisit.poll();
            int nodeIndx = currentVert.getIndx();
            double distanceToVert = currentVert.getCost();

            int adjMatLength = adjMatrix[nodeIndx].length;
            // Check distances to neighbours
            for (int i = 0; i < adjMatrix[nodeIndx].length ; i++) {

                if (adjMatrix[nodeIndx][i] == 0 && i != nodeIndx) {
                    continue;
                }

                double distanceToNeighbour = adjMatrix[nodeIndx][i];
                double newDistance = distanceToNeighbour + distanceToVert;

                // Vertex currently not visited
                if (distanceToNeighbour < Double.MAX_VALUE && distances[i] == Double.MAX_VALUE) {
                    toVisit.add(new NextVertex(i, newDistance));
                }

                // Newly calculated distance is smaller
                if (newDistance < distances[i]) {
                    distances[i] = newDistance;
                }
            }
        }


        return distances;
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



    private class NextVertex {

        private int indx;
        private double cost;


        public NextVertex(int indx) {
            this.indx = indx;
            this.cost = Double.MAX_VALUE;
        }

        public NextVertex(int indx, double cost) {
            this.indx = indx;
            this.cost = cost;
        }

        public void update(double cost) {
            this.cost = cost;
        }

        public int getIndx() {
            return this.indx;
        }

        public double getCost() {
            return this.cost;
        }
    }

}
