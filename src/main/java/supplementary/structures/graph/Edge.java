package supplementary.structures.graph;

import java.util.Objects;

/**
 * Represents the weight of an edge.
 *
 * @author Maksim Sandybekov
 * @date 2019-11-25
 */
public class Edge implements Comparable<Edge> {

    private Vertex toVertex;
    private Vertex fromVertex;
    private double value;

    public Edge(Vertex fromVertex, Vertex toVertex) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.value = 0;
    }

    public Edge(Vertex fromVertex, Vertex toVertex, double value) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.value = value;
    }


    // --------------------------
    // Setter/-Getter
    // --------------------------

    public void setValue(double value) {
        this.value = value;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public Vertex getFromVertex() {
        return fromVertex;
    }

    public double getValue() {
        return value;
    }



    // --------------------------
    // HashCode/-Equals
    // --------------------------

    @Override
    public String toString() {
        return "(" + this.value +"): " + this.fromVertex.toString() + " -> " + this.toVertex.toString();
    }


    @Override
    public int compareTo(Edge o) {

        double currentDistance = this.value;
        double otherDistance = o.getValue();

        if (currentDistance == otherDistance) {
            return 0;
        } else if (currentDistance < otherDistance) {
            return -1;
        }

        return 1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Double.compare(edge.value, value) == 0 &&
                toVertex.equals(edge.toVertex) &&
                fromVertex.equals(edge.fromVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toVertex, fromVertex, value);
    }
}
