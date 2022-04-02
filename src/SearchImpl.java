public class SearchImpl extends Search {  // inheritance from class search to override toString and compareTo functions
    public SearchImpl(String name) {     // parent class = Search.java
        super(name);
     }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Search otherVertex) {
        return super.compareTo(otherVertex);
    }
}