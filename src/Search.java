import java.util.ArrayList;
import java.util.List;
import static java.lang.Double.MAX_VALUE;

public class Search implements Comparable<Search> {
    private double shortestPath;
    public String n;
    private Search pathV;
    private final List<Finder> s;                  // used comparable to order objects of the user defined class as it is much
                                                  // easier to use the interface than making a new method
    public Search(String n){             // randomly generated getters and setters from the IDE
        this.s = new ArrayList<>();
        this.n =n;
        shortestPath = MAX_VALUE;
    }
    public int compareTo(Search compare) {
        return Double.compare(this.shortestPath, compare.shortestPath);
    }
    public String toString() {  // to convert the into string and make it readable
        return n;
    }
    public List<Finder> getPath() {
        return s;
    }

    public Search getDistance() {
        return pathV;
    }
    public double getSP() {
        return shortestPath;
    }
    public void setSP(double shortest) {
        this.shortestPath = shortest;
    }
    public void setDistance(Search d) {
        this.pathV = d;
    }
}

// class Search is finished