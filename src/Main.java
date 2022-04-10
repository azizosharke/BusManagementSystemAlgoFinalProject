import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.stream.Stream;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.*;
import static java.util.Collections.*;
import static java.util.Collections.sort;

// used generated regex to generate the numbers I needed for the times in format of (HH:MM:SS)
//   https://regexr.com/
//   https://stackoverflow.com/questions/4736/learning-regular-expressions
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File busSystem = new File("stop_times.txt");
        Graph dijkstra = new Graph("stops.txt", "transfers.txt", "stop_times.txt");
        System.out.println("""
                ***********************************************************\s
                 WELCOME TO VANCOUVER BUS SYSTEM DATA ☺ \s
                ***********************************************************""");
        while (true) {
            TernarySearchTree Q2 = new TernarySearchTree("stops.txt");
            Scanner input = new Scanner(System.in);
            System.out.println("""
                    ***********************************************************\s
                     PLEASE SELECT ONE OF THE FOLLOWING OPTIONS BELOW ↓\s
                    ***********************************************************
                    """);
            Arrays.asList("PRESS [0] TO EXIT THE PROGRAM", "PRESS [1]  FIND THE SHORTEST PATHS BETWEEN TWO BUS STOPS",
                    "PRESS [2]  SEARCH FOR THE REQUIRED BUS STOP",
                    "PRESS [3]  SEARCH FOR THE ARRIVAL TIME FOR THE BUS AT THE STATION").forEach(System.out::println);
            if (!input.hasNextInt()) {
                System.out.println("""
                        ***********************************************************\s
                         THIS IS AN INVALID INPUT. PLEASE TRY AGAIN  \s
                        ***********************************************************""");
            } else {
                var userInterFace = input.nextInt();
                input.nextLine();
                if (userInterFace < 0 || userInterFace > 3) {
                } else {
                    try {
                        switch (userInterFace) {
                            case 0 -> {
                                System.out.println("""
                                        ***********************************************************\s
                                         BYE. HOPE YOU HAVE A LOVELY DAY ☺ \s
                                        ***********************************************************""");
                                System.exit(0);
                            }
                        }
                        switch (userInterFace) {
                            case 1 -> {
                                String start = "";
                                String stop = "";
                                HashMap<String, Search> hashMap = dijkstra.searchMap;
                                boolean system;
                                system = true;
                                do {
                                    String numbers;
                                    numbers = "[0-9]+";
                                    System.out.println("PLEASE ENTER THE NUMBER OF THE STARTING STOP:");
                                    start = input.nextLine();
                                    System.out.println("PLEASE ENTER THE NUMBER OF THE  DESTINATION STOP:");
                                    stop = input.nextLine();

                                    if (!start.matches(numbers) || !stop.matches(numbers)) {
                                        System.out.println("""
                                                ***********************************************************\s
                                                 ONLY DIGITS ARE ALLOWED!! PLEASE TRY AGAIN
                                                ***********************************************************""");
                                    } else {
                                        if (hashMap.get(start) != null && hashMap.get(stop) != null) {
                                            system = false;
                                            {
                                            }
                                        } else {
                                            System.out.println("""
                                                    ************************************************************************************************\s
                                                     PLEASE TRT AGAIN WITH A DIFFERENT STOP NUMBER! THE BUS STOPS ENTERED DO NOT EXIST IN THE SYSTEM.
                                                    ************************************************************************************************""");
                                        }
                                        System.out.println("PATH DO NOT EXIST. PLEASE TRY AGAIN");


                                    }
                                } while (system);
                                Search answer = hashMap.get(start);
                                Search arrival = hashMap.get(stop);
                                dijkstra.pathCalculator(answer);
                                System.out.println(MessageFormat.format("THE OVERALL PATH FROM  {0} TO {1} IS {2}"
                                       , answer, arrival, dijkstra.shortestPath(arrival)));
                                System.out.println(" [THE OVERALL COST OF THE PATH IS] --> " + dijkstra.c + "\n");
                            }
                            case 2 -> {
                                System.out.print(
                                        "PLEASE ENTER THE STOP YOU ARE LOOKING FOR OR SOME LETTERS OF THR STOP : ");
                                String userInput = input.nextLine();
                                for (String information : Q2.busStopInfo(userInput.toUpperCase(Locale.ROOT))) {
                                    System.out.println(information);
                                }
                            }
                            case 3 -> BusManagement.Bus(busSystem);
                        }
                    } catch (IOException i) {
                        System.out.println();
                        i.printStackTrace();
                    }
                }
            }
        }
    }
}

class BusManagement {
    public static void BusArrival(ArrayList<String> fileList) {
        sort(fileList);
        System.out.println(
                "(|Trip ID|Arrival Time|Departure Time|Stop ID|Stop sequence|Stop Headsign" +
                        "|Pick Up Type|Drop Off Type|Shape|Distance Traveled|)");
        int j = 0, listSize = fileList.size();
        while (j < listSize) {
            String l = fileList.get(j);
            System.out.println(l);
            System.out.println("-------------------------------------------------");
            j++;
        }
    }
    public static ArrayList<String> FileReader(File f) throws IOException {
        ArrayList<String> fileName;
        fileName = (ArrayList<String>) readAllLines(get("stop_times.txt"));
        try
                (var stringStream =
                         Files.lines(f.toPath()).map(String::trim).filter(s -> {
                             return !
                                     "(([0-1]?[0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]".matches(s);
                         })) {
        }
        return fileName;
    }

    public static void Bus(File f) throws IOException {
        try {
            var busTime = FileReader(f);
            ArrayList<String> results;
            results = new ArrayList<>();
            var input = new Scanner(System.in);
            System.out.println("ENTER THE TIME IN [****(HH:MM:SS)****] ");
            var times = false;
            try {
                String busStop = input.next();
                if (!busStop.matches("(([0-1]?[0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]")) {
                    System.out.println((busStop.charAt(2) == ':') && (busStop.charAt(5) == ':')
                            && ((int) busStop.charAt(1) >= 4) ?
                            "PLEASE TRY AGAIN AS YOUR INPUT EXCEEDS [23:59:59]!! " : "PLEASE TRY AGAIN AS YOUR INPUT IS " +
                            "NOT IN THE FORMAT [****(HH:MM:SS)****]!! ");
                } else {
                    switch (busStop.length()) {
                        case 7 -> busStop += " ";
                    }
                    for (String s : busTime) {
                        if (!s.contains(busStop)) {
                        } else {
                            results.add(s);
                        }
                        times = true;
                    }
                }
            } catch (Exception i) {
                System.out.println("INVALID! PLEASE TRY AGAIN.");
            }
            if (results.size() <= 0) {
                if (times) {
                    System.out.println("ARRIVAL TIME ENTERED CAN NOT BE FOUND  ");
                }
            } else {
                BusArrival(results);
            }

        } catch (FileNotFoundException i) {
            System.out.println("SYSTEM CAN NOT FIND THE FILE, PLEASE DO NOT FORGET TO INPUT THE FILE ");
        }
    }
}



