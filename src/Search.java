import java.util.ArrayList;
import java.util.List;
import static java.lang.Double.MAX_VALUE;

public class Search {
    private double shortestPath;
    public String n;
    private Search pathV;
    private final List<Finder> s;


    public Search(String n){             // randomly generated getters and setters from the IDE
        this.s = new ArrayList<>();
        this.n =n;
        shortestPath = MAX_VALUE;
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
