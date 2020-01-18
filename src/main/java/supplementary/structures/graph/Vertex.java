package supplementary.structures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Representing the vertex of an graph.
 *
 * @param <T> - Type representing an vertice definition.
 * @author Maksim Sandykeov
 * @date 2019-11-25
 */
public class Vertex<T extends Comparable> implements Cloneable {

    private T definition;
    private boolean visited;
    private HashMap<Vertex, Vertex> neighbours; // in directional graph only the out-neighbours

    public Vertex(T definition) {
        this.definition = definition;
        this.visited = false;
        this.neighbours = new HashMap<Vertex, Vertex>();
    }


    /**
     * Adding a neighbour to node neighbours
     *
     * @param vertex - A vertex to add to the neighbours
     */
    public void addNeighbour(Vertex vertex) {

        HashMap<Vertex, Vertex> currentNeighbours = this.getNeighbours();
        if (!currentNeighbours.containsKey(vertex)) {
            currentNeighbours.put(vertex, vertex);
        }
    }


    /**
     * Remove and return a neighbour.
     *
     * @param vertex - A vertex to search for in neighbours.
     * @return Neighbour vertex
     */
    public Vertex removeNeighbour(Vertex vertex) {

        HashMap<Vertex, Vertex> currentNeighbours = this.getNeighbours();
        Vertex neighbour = null;
        if (currentNeighbours.containsKey(vertex)) {
            neighbour = currentNeighbours.remove(vertex);
        }

        return neighbour;
    }



    // -----------------------------
    // Setter/-Getter
    // -----------------------------

    public void setDefinition(T definition) {
        this.definition = definition;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setNeighbours(HashMap<Vertex, Vertex> neighbours) { this.neighbours = neighbours; }

    public T getDefinition() {
        return definition;
    }

    public boolean wasVisited() {
        return this.visited;
    }

    public HashMap<Vertex, Vertex> getNeighbours() {
        return this.neighbours;
    }


    // -----------------------------
    // Override methods
    // -----------------------------

    @Override
    public Vertex clone() {

        return new Vertex(this.definition);
    }

    @Override
    public String toString() {
        return this.definition.toString();
    }

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
