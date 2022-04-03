import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.Scanner;
// used generated regex to generate the numbers I needed for the times in format of (HH:MM:SS)
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File busSystem = new File("stop_times.txt");
        Graph dijkstra = new Graph("stops.txt", "transfers.txt", "stop_times.txt");
        System.out.println("""
                ***********************************************************\s
                 WELCOME TO VANCOUVER BUS SYSTEM DATA  \s
                ***********************************************************""");
        while (true) {
            TernarySearchTree Q2 = new TernarySearchTree("stops.txt");
            Scanner input = new Scanner(System.in);
            System.out.println("""
                    ***********************************************************\s
                     PLEASE SELECT ONE OF THE FOLLOWING OPTIONS : (0,1,2,3)\s
                    ***********************************************************
                    """);

            Arrays.asList("PRESS [0] TO EXIST THE PROGRAM", "PRESS [1]TO FIND THE SHORTEST PATHS BETWEEN TWO BUS STOPS", "PRESS [2] TO SEARCH FOR THE REQUIRED BUS STOP", "PRESS [3] TO SEARCH FOR THE ARRIVAL TIME FOR THE BUS AT THE STATION").forEach(System.out::println);
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
                 BYE. HOPE YOU HAVE A LOVELY DAY  \s
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
                                if (system) {
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
                                        }
                                    } while (system);
                                }
                                Search answer = hashMap.get(start);
                                Search arrival = hashMap.get(stop);
                                dijkstra.pathCalculator(answer);
                                System.out.println(MessageFormat.format("THE OVERALL PATH FROM  {0} TO {1} IS {2}", answer, arrival, dijkstra.shortestPath(arrival)));

                                System.out.println(" [THE OVERALL COST OF THE PATH IS] --> " + dijkstra.c + "\n");
                            }
                            case 2 -> {
                                System.out.print(
                                        "PLEASE ENTER THE STOP YOU ARE LOOKING FOR OR SOME LETTERS OF THR STOP : ");
                                String userInput = input.nextLine();
                                for (String information : Q2.busStopInfo(userInput)) {
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


