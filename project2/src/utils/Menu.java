/** Class that handles the command line interface. According to the user query,
the appropriate print method will be invoked to show the necessary information.
 */

package utils;

import java.util.ArrayList;
import java.util.Scanner;
import vehicle.*;

public class Menu {
    public static void getUserQuery(ArrayList<Vehicle> vehicleList) {
        Scanner keyboard = new Scanner(System.in);
        int userInput = keyboard.nextInt();

        switch (userInput) {
            case 1:
                SalesRecord.printAllSoldVehiclesList(vehicleList);
                break;
            case 2:
                SalesRecord.printSoldSedanList(vehicleList);
                break;
            case 3:
                SalesRecord.printSoldHatchbackList(vehicleList);
                break;
            case 4:
                SalesRecord.printSoldMinivanList(vehicleList);
                break;
            case 5:
                SalesRecord.printSoldPickupTruckList(vehicleList);
                break;
            case 6:
                SalesRecord.printSoldBicycleList(vehicleList);
                break;
            default:
                break;
        }
        keyboard.close();
    }

    public static void printMenuStartMessage() {
        System.out.println("Please press,");
        System.out.println("1 to see all sold vehicles list");
        System.out.println("2 to see sold sedan list");
        System.out.println("3 to see sold hatchback list");
        System.out.println("4 to see sold minivan list");
        System.out.println("5 to see sold pickup truck list");
        System.out.println("6 to see sold bicycle list");
        System.out.println("Please enter your choice:");
    }
}
