/**
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *    https://algs4.cs.princeton.edu/44sp/DirectedEdge.java.html
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class DirectedEdge {
    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        if (v < 0) throw new IllegalArgumentException("Vertex names must be non-negative integers");
        if (w < 0) throw new IllegalArgumentException("Vertex names must be non-negative integers");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;

    }
    public int from() {
        return v;
    }

    /**
     * Returns the head vertex of the directed edge.
     * @return the head vertex of the directed edge
     */
    public int to() {
        return w;
    }

    /**
     * Returns the weight of the directed edge.
     * @return the weight of the directed edge
     */
    public double weight() {
        return weight;
    }
}



//Copyright © 2000–2019, Robert Sedgewick and Kevin Wayne.
       // Last updated: Wed Jan 20 05:27:29 EST 2021.