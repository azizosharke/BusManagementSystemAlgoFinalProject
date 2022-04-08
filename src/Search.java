import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.lang.Double.MAX_VALUE;
public class Search implements Comparable<Search> {
    private double shortestPath;
    public String n;
    private Search pathV;
    private final List<Finder> s;           // used comparable to order objects of the user defined class as it is much
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
    public void searchFinder(Finder finder) {
        this.s.add(finder);
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
 record Finder(double w, Search v) {    // converted into record as it is better for plain data carriers
    public double weightFinder() {
        return w;
    }
    public Search searchV() {
        return v;
    }
    @Override
    public boolean equals(Object obj) {                                    // overriding and checking in the main system
        boolean result;
        if (obj == this) {
            result = true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            result = false;
        } else {
            var that = (Finder) obj;
            result = Double.doubleToLongBits(this.w) == Double.doubleToLongBits(that.w) &&
                    Objects.equals(this.v, that.v);
        }
        return result;
    }
    @Override
    public int hashCode() {
        return Objects.hash(w, v);
    }

    @Override
    public String toString() {                // override for used variables
        return "Finder[" +
                "w=" + w + ", " +
                "v=" + v + ']';
    }
}
// class Search is finished