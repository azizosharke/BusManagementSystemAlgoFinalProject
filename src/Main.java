import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        java.io.File file = new java.io.File("stop_times.txt");
        System.out.println("***********************************************************" +
                " \n WELCOME TO VANCOUVER BUS SYSTEM DATA   \n" +
                "***********************************************************\n");
        Scanner input = new Scanner(System.in);
        System.out.println("***********************************************************" +
                " \n PLEASE SELECT ONE OF THE FOLLOWING OPTIONS : (0,1,2,3) \n" +
                "***********************************************************\n");

        System.out.println("- PRESS [0] TO EXIST THE PROGRAM - ");
        System.out.println("- PRESS [1]TO FIND THE SHORTEST PATHS BETWEEN TWO BUS STOPS - ");
        System.out.println("- PRESS [2] TO SEARCH FOR THE REQUIRED BUS STOP - ");
        System.out.println("- PRESS [3] TO SEARCH FOR THE ARRIVAL TIME FOR THE BUS AT THE STATION -");
        if (!input.hasNextInt()) {                                                         // for invalid inputs
            System.out.println("THIS IS AN INVALID INPUT. PLEASE TRY AGAIN");
        }

    }



}
