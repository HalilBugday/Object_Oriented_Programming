/** Class to read the vehicle records from the CSV file.
Has the necessary method to read the CSV file and return Vehicle objects.

 */

package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import vehicle.automobile.*;
import vehicle.bicycle.*;
import vehicle.pickuptruck.*;
import vehicle.*;

import java.util.ArrayList;

public class FileIO {

    public static ArrayList<Vehicle> getVehicleArrayFromCSVFile(String filePath) {
        String line = "";

        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            ArrayList<Vehicle> vehicleArray = new ArrayList<Vehicle>();

            while ((line = br.readLine()) != null) {
                String[] tokenArray = getTokenArray(line);
                Vehicle vehicle = returnVehicleObject(tokenArray);
                vehicleArray.add(vehicle);
            }
            br.close();
            return vehicleArray;
        } catch (IOException e) {
            System.err.println(e + " Returning an empty Vehicle list.");
            return new ArrayList<Vehicle>(0);
        }

    }

    private static String[] getTokenArray(String strLine) {

        StringTokenizer st = new StringTokenizer(strLine, ",");
        int tokenSize = st.countTokens();
        String[] tokenArray = new String[tokenSize];
        for (int j = 0; j < tokenSize; j++) {
            tokenArray[j] = st.nextToken();
        }
        return tokenArray;
    }

    private static Vehicle returnVehicleObject(String[] tokenArray) {
        char vehicleType = tokenArray[0].charAt(0);

        switch (vehicleType) {
            case 'P':
                return new PickupTruck(tokenArray[0], tokenArray[1], tokenArray[2], Integer.parseInt(tokenArray[3]),
                        Float.parseFloat(tokenArray[6]), tokenArray[4], tokenArray[5]);
            case 'H':
                boolean cityMode = false;
                if (tokenArray[4].equalsIgnoreCase("yes"))
                    cityMode = true;
                return new Hatchback(tokenArray[0], tokenArray[1], tokenArray[2], Integer.parseInt(tokenArray[3]),
                        Float.parseFloat(tokenArray[6]), Float.parseFloat(tokenArray[5]), cityMode);
            case 'S':
                return new Sedan(tokenArray[0], tokenArray[1], tokenArray[2], Integer.parseInt(tokenArray[3]),
                        Float.parseFloat(tokenArray[6]), Float.parseFloat(tokenArray[5]), tokenArray[4]);
            case 'M':
                return new Minivan(tokenArray[0], tokenArray[1], tokenArray[2], Integer.parseInt(tokenArray[3]),
                        Float.parseFloat(tokenArray[6]), Float.parseFloat(tokenArray[5]),
                        Integer.parseInt(tokenArray[4]));
            case 'B':
                return new Bicycle(tokenArray[0], tokenArray[1], tokenArray[2], Integer.parseInt(tokenArray[3]),
                        Float.parseFloat(tokenArray[6]), tokenArray[4],
                        tokenArray[5]);
            default:
                System.err.println("This vehicle is unknown, returning a simple Vehicle object.");
                return new Vehicle();
        }

    }
}
