import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

import static java.lang.Double.parseDouble;

//https://algs4.cs.princeton.edu/44sp/DijkstraSP.java.html
// by Sedgewick and Wayne


public class Graph {
    public ArrayList<Double> w;
    public Double c;
    public HashMap<String,Search> searchMap = new HashMap<>();
    public ArrayList<String[]> busStops;
    public ArrayList<String> firstStop;
    public ArrayList<String> lastStops;
    public ArrayList<Finder> edge = new ArrayList<>();
    public Graph() {
        return;
    }
    public Graph(String stopDes, String transfers, String stops) throws FileNotFoundException
    {
        File file = new File(stopDes);
        Scanner scanner = new Scanner(file);
        if (scanner.hasNextLine()) {
            do {
                var systemSearch = scanner.nextLine();
                String[] stopBus;
                stopBus = systemSearch.split(",");
                var v = new Search(stopBus[0]);
                searchMap.put(stopBus[0], v);
            } while (scanner.hasNextLine());
        }
        scanner.close();
        File busStations = new File(transfers);
        Scanner scannerB = new Scanner(busStations);
        ArrayList<String> street;
        street = new ArrayList<>();
        ArrayList<String> streets;
        streets = new ArrayList<>();
        ArrayList<Double> root;
        root = new ArrayList<>();
        if (scannerB.hasNextLine()) {
            do {
                String edge;
                edge = scannerB.nextLine();
                String[] e;
                e = edge.split(",");
                street.add(e[0]);
                streets.add(e[1]);
                switch (e[2]) {
                    case "0" -> root.add(2.0);
                    case "2" -> root.add(parseDouble(e[3]) / 100);
                    default -> root.add(1.0);
                }
            } while (scannerB.hasNextLine());
        }
//        scannerB.close();
//        firstStop = street;
//        lastStops = streets;
//        w = root;
//        int n = 1;
//        while (n < street.size()) {
//            var intersectionA = searchMap.get(firstStop.get(n));
//            var intersectionB = searchMap.get(lastStops.get(n));
//            var edgeWeight = root.get(n);
//            intersectionA.searchFinder(new Finder(edgeWeight,intersectionB));
//            searchMap.put(firstStop.get(n), intersectionA);
//            n += 1;
        }
        File stopFileTimes = new File(stops);
        Scanner scannerC = new Scanner(stopFileTimes);
        busStops = new ArrayList<>();
        if (scannerC.hasNextLine()) {
            do {
                String a;
                a = scannerC.nextLine();
                String[] array;
                array = a.split(",");
                String trip;
                trip = array[0];
                String stop;
                stop = array[3];
                String[] arrayB = {trip, stop};
                busStops.add(arrayB);
            } while (scannerC.hasNextLine());
        }
//        String Trip;
//        Trip = busStops.get(1)[0];
//        String Stop;
//        Stop = busStops.get(1)[1];
//        Search a = searchMap.get(Stop);
//        int m = 2;
//        while (m < busStops.size()) {
//            String TripB = busStops.get(m)[0];
//            String StopB = busStops.get(m)[1];
//            if (!Trip.equals(TripB)) {
//                Trip =TripB;
//                a = searchMap.get(StopB);
//            } else {
//                Search b = searchMap.get(StopB);
//                a.searchFinder(new Finder(1.0,b));
//
//                searchMap.put(a.n, a);
//                a = b;
//            }
//            m+= 1;
        }
    }





}


