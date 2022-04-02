import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class Graph {

    public Graph() {
        return;
    }
    public Graph(String stopDes, String transfers, String stops) throws FileNotFoundException {
        File file = new File(stopDes);
        Scanner scanner = new Scanner(file);
    }
}


