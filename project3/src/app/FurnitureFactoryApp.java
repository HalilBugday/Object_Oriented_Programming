package app;

import java.util.ArrayList;
import collections.FurnitureToMakeQueue;
import collections.FurnitureToMakeStack;
import furniture.Furniture;
import manufacturer.Manufacturer;
import rawMaterial.RawMaterialQueue;
import rawMaterial.RawMaterialStack;
import utils.FileIO;
import vendor.Vendor;

public class FurnitureFactoryApp {
    public static void main(String[] args) {
        Vendor vendor = new Vendor(FileIO.getVendorPossessionsFromCSVFile("src/data/VendorPossessions.csv"));

        Manufacturer manufacturer1 = new Manufacturer(new RawMaterialQueue(), new ArrayList<Furniture>(),
                FileIO.getManufacturerMaterialsFromCSVFile("src/data/manufacturer/Manufacturer1Materials.csv"),
                new FurnitureToMakeStack(FileIO
                        .getManufacturerFurnituresFromCSVFile("src/data/manufacturer/Manufacturer1Furnitures.csv")));
        Manufacturer manufacturer2 = new Manufacturer(new RawMaterialStack(), new ArrayList<Furniture>(),
                FileIO.getManufacturerMaterialsFromCSVFile("src/data/manufacturer/Manufacturer2Materials.csv"),
                new FurnitureToMakeQueue(FileIO
                        .getManufacturerFurnituresFromCSVFile("src/data/manufacturer/Manufacturer2Furnitures.csv")));

        for (int day = 1; day <= 3; day++) {
            manufacturer1.buyRawMaterialsOfTheDay(day, vendor); // ! TODO remember to delete the list of the day after
                                                                // buying
            manufacturer2.buyRawMaterialsOfTheDay(day, vendor);
            manufacturer1.produceFurniture(day);
            manufacturer2.produceFurniture(day);
        }

    }
}