package furniture;

import java.util.List;
import java.util.Map;

import utils.FileIO;
import java.util.Arrays;
import java.util.HashMap;

public abstract class Furniture {
    private String furnitureCode;
    private double furnitureQuality;
    private static Map<String, String[]> furniturePartsMap = new HashMap<String, String[]>();

    public Furniture() {
        furnitureCode = "";
        furnitureQuality = 0;
    }

    public Furniture(String furnitureCode, double furnitureQuality) {
        this.furnitureCode = furnitureCode;
        this.furnitureQuality = furnitureQuality;
    }

    public Furniture(Furniture aFurniture) {
        this.furnitureCode = aFurniture.getFurnitureCode();
        this.furnitureQuality = aFurniture.getFurnitureQuality();
    }

    public String getFurnitureCode() {
        return this.furnitureCode;
    }

    public void setFurnitureCode(String furnitureCode) {
        this.furnitureCode = furnitureCode;
    }

    public double getFurnitureQuality() {
        return this.furnitureQuality;
    }

    public void setFurnitureQuality(int furnitureQuality) {
        this.furnitureQuality = furnitureQuality;
    }

    public String toString() {
        String toString = "Furniture: " + getClass().getSimpleName() + "Furniture Code: " + this.furnitureCode
                + "Furniture Quality: " + this.furnitureQuality;
        return toString;
    }

    public boolean equals(Furniture aFurniture) {
        return (this.furnitureCode.equals(aFurniture.getFurnitureCode())
                && this.furnitureQuality == aFurniture.getFurnitureQuality());
    }

    public boolean equals(Object object){
        if (object == null){
            return false;
        }
        if (getClass() != object.getClass()){
            return false;
        }
        Furniture aFurniture = (Furniture) object;

        return (this.furnitureCode.equals(aFurniture.getFurnitureCode())
                && this.furnitureQuality == aFurniture.getFurnitureQuality());
    }

    public static Map<String, String[]> getFurniturePartsMap() { // TODO consider convention for static getter
        return furniturePartsMap;
    }

    public abstract Furniture clone();

    static {
        List<String[]> furniturePartsList = FileIO.getFurniturePartsFromCSVFile("src/data/FurnitureParts.csv");
        for(int i = 0; i < furniturePartsList.size(); i++) {
            String[] furnitureParts = furniturePartsList.get(i);
            String key = furnitureParts[0];
            String[] value = Arrays.copyOfRange(furnitureParts, 1, furnitureParts.length);
            furniturePartsMap.put(key, value);
        }
    }
}
