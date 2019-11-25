package supplementary.structures.graph;

import java.util.Hashtable;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Vertices of an graph.
 *
 * @param <T> - Type representing an vertice definition.
 * @author Maksim Sandykeov
 * @date 2019-11-25
 */
public class Vertex<T> {

    private T definition;
    private boolean visited;

    public Vertex(T definition) {
        this.definition = definition;
        this.visited = false;
    }


    // -----------------------------
    // Setter/-Getter
    // -----------------------------

    public T getDefinition() {
        return definition;
    }

    public boolean wasVisited() {
        return this.visited;
    }

    public void setDefinition(T definition) {
        this.definition = definition;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }




    // -----------------------------
    // hashCode and equals methods
    // -----------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertice = (Vertex<?>) o;
        return Objects.equals(definition, vertice.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(definition);
    }
}
