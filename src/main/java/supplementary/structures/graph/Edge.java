package supplementary.structures.graph;

/**
 * Represents the weight of an edge.
 *
 * @author Maksim Sandybekov
 * @date 2019-11-25
 */
public class Edge {

    private Vertice toVertice;
    private Vertice fromVertice;
    private double value;

    public Edge(Vertice fromVertice, Vertice toVertice, double value) {
        this.toVertice = toVertice;
        this.fromVertice = fromVertice;
        this.value = value;
    }


    // --------------------------
    // Setter/-Getter
    // --------------------------

    public void setToVertice(Vertice toVertice) {
        this.toVertice = toVertice;
    }

    public void setFromVertice(Vertice fromVertice) {
        this.fromVertice = fromVertice;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Vertice getToVertice() {
        return toVertice;
    }

    public Vertice getFromVertice() {
        return fromVertice;
    }

    public double getValue() {
        return value;
    }
}
