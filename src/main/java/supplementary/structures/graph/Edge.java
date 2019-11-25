package supplementary.structures.graph;

import java.util.Objects;

/**
 * Represents the weight of an edge.
 *
 * @author Maksim Sandybekov
 * @date 2019-11-25
 */
public class Edge {

    private Vertex toVertex;
    private Vertex fromVertex;
    private double value;

    public Edge(Vertex fromVertex, Vertex toVertex, double value) {
        this.toVertex = toVertex;
        this.fromVertex = fromVertex;
        this.value = value;
    }


    // --------------------------
    // Setter/-Getter
    // --------------------------

    public void setToVertex(Vertex toVertex) {
        this.toVertex = toVertex;
    }

    public void setFromVertex(Vertex fromVertex) {
        this.fromVertex = fromVertex;
    }

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
