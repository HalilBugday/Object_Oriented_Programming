package utils;

import rawMaterial.RawMaterial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class FileIO {
    public static List<RawMaterial> getVendorPossessionsFromCSVFile(String vendorPossessionsFilePath) {
        String newLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader(vendorPossessionsFilePath));
            List<RawMaterial> vendorPossesionList = new ArrayList<RawMaterial>();
            while ((newLine = br.readLine()) != null) {
                String[] tokenArray = getTokenArray(newLine);
                vendorPossesionList.add(new RawMaterial(tokenArray[0], Integer.valueOf(tokenArray[1])));
            }
            br.close();
            return vendorPossesionList;
        } catch (IOException e) {
            System.out.println("No vendor possessions CSV file at this file path: " + vendorPossessionsFilePath
                    + "\nReturning an empty list!");
            return new ArrayList<RawMaterial>();
        }

    }

    public static void getRawMaterialPropertiesFromCSVFile(String rawMaterialPropertiesFilePath) {
        List<String[]> rawMaterialPropertiesList = readCSVFile(rawMaterialPropertiesFilePath);
        Map<String, Integer> tempRawMaterialCostMap = RawMaterial.getRawMaterialCostMap();
        Map<String, Integer> tempRawMaterialVolumeMap = RawMaterial.getRawMaterialVolumeMap();
        for (int i = 0; i < rawMaterialPropertiesList.size(); i++) {
            String[] rawMaterialProperties = rawMaterialPropertiesList.get(i);
            tempRawMaterialCostMap.put(rawMaterialProperties[0],
                    Integer.valueOf(rawMaterialProperties[4])); // string, cost
            tempRawMaterialVolumeMap.put(rawMaterialProperties[0],
                    calculateVolumeOfRawMaterial(rawMaterialProperties)); // string, volume
        }
        RawMaterial.setRawMaterialCostMap(tempRawMaterialCostMap);
        RawMaterial.setRawMaterialVolumeMap(tempRawMaterialVolumeMap);
    }

    public static List<String[]> getFurniturePartsFromCSVFile(String furniturePartsFilePath) { // TODO same thing as the
                                                                                               // raw material
                                                                                               // properties, how to
                                                                                               // hold these static
                                                                                               // data?
        return readCSVFile(furniturePartsFilePath);
    }

    public static List<String[]> getManufacturerFurnituresFromCSVFile(String manufacturerFurnituresFilePath) { // TODO
                                                                                                               // same
                                                                                                               // thing
                                                                                                               // as the
                                                                                                               // raw
                                                                                                               // material
                                                                                                               // properties,
                                                                                                               // how to
                                                                                                               // hold
                                                                                                               // these
                                                                                                               // static
                                                                                                               // data?
        List<String[]> listOfStringArray = readCSVFile(manufacturerFurnituresFilePath);
        List<String[]> listToReturn = new ArrayList<>();
        for(int i = 0; i < listOfStringArray.size(); i++) {
            String[] furnituresForTheDay = listOfStringArray.get(i); // TODO bunları okuyup nasıl tutmak daha iyi olur
            listToReturn.add(Arrays.copyOfRange(furnituresForTheDay, 1, furnituresForTheDay.length));
        }
        return listToReturn;
    }

    public static List<String[]> getManufacturerMaterialsFromCSVFile(String manufacturerMaterialsFilePath) { // TODO
                                                                                                             // same
                                                                                                             // thing as
                                                                                                             // the raw
                                                                                                             // material
                                                                                                             // properties,
                                                                                                             // how to
                                                                                                             // hold
                                                                                                             // these
                                                                                                             // static
                                                                                                             // data?
        return readCSVFile(manufacturerMaterialsFilePath);
    }

    private static List<String[]> readCSVFile(String filePath) {
        String newLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            List<String[]> stringArrayList = new ArrayList<String[]>();

            while ((newLine = br.readLine()) != null) {
                stringArrayList.add(getTokenArray(newLine)); // TODO bunları okuyup nasıl tutmak daha iyi olur
            }

            br.close();
            return stringArrayList;
        } catch (FileNotFoundException e) {
            System.out.println("No such file on path: " + filePath
                    + "\nReturning an empty list!");
            return new ArrayList<String[]>();
        } catch (IOException e) {
            System.out.println("Error while opening file at this path: " + filePath
                    + "\nReturning an empty list!");
            return new ArrayList<String[]>();
        }
    }

    private static String[] getTokenArray(String line) {
        StringTokenizer st = new StringTokenizer(line, ",");
        int tokenCount = st.countTokens();
        String[] tokenArray = new String[tokenCount];
        for (int i = 0; i < tokenCount; i++) {
            tokenArray[i] = st.nextToken();
        }
        return tokenArray;
    }

    private static Integer calculateVolumeOfRawMaterial(String[] rawMaterialProperties) {
        return Integer.valueOf(rawMaterialProperties[1]) * Integer.valueOf(rawMaterialProperties[2])
                * Integer.valueOf(rawMaterialProperties[3]);
    }
}
