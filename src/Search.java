import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.MAX_VALUE;
public class Search {
    private double shortestPath;
    public String n;
    private Search pathV;
    private final List<Finder> s;


    public Search(String n){
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
}
