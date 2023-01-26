package utils;

import java.util.ArrayList;
import vehicle.Vehicle;
import vehicle.automobile.*;
import vehicle.bicycle.Bicycle;
import vehicle.pickuptruck.*;
//A class that has methods which print the arraylists with needed information.
public class SalesRecord {
    public static void printAllSoldVehiclesList(ArrayList<Vehicle> vehicleList) {
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.toString());
        }

    }

    public static void printSoldSedanList(ArrayList<Vehicle> vehicleList) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getClass() == Sedan.class) {
                System.out.println(vehicle.toString());
            }
        }

    }

    public static void printSoldHatchbackList(ArrayList<Vehicle> vehicleList) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getClass() == Hatchback.class) {
                System.out.println(vehicle.toString());
            }
        }
    }

    public static void printSoldMinivanList(ArrayList<Vehicle> vehicleList) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getClass() == Minivan.class) {
                System.out.println(vehicle.toString());
            }
        }
    }

    public static void printSoldPickupTruckList(ArrayList<Vehicle> vehicleList) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getClass() == PickupTruck.class) {
                System.out.println(vehicle.toString());
            }
        }
    }

    public static void printSoldBicycleList(ArrayList<Vehicle> vehicleList) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getClass() == Bicycle.class) {
                System.out.println(vehicle.toString());
            }
        }
    }
}
