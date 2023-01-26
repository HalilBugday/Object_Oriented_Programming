package manufacturer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import collections.FurnitureToMakeCollection;
import collections.RawMaterialCollection;
import furniture.*;
import rawMaterial.RawMaterial;
import vendor.Vendor;

public class Manufacturer {
    private RawMaterialCollection rawMaterialCollection;
    private List<Furniture> furnitureList;
    private List<String[]> rawMaterialsToBuyList;
    private FurnitureToMakeCollection furnitureToMakeCollection;

    public Manufacturer() {
    }

    public Manufacturer(RawMaterialCollection rawMaterialCollection, List<Furniture> furnitureList,
            List<String[]> rawMaterialsToBuyList, FurnitureToMakeCollection furnitureToMakeCollection) {
        this.rawMaterialCollection = rawMaterialCollection;
        this.furnitureList = furnitureList;
        this.rawMaterialsToBuyList = rawMaterialsToBuyList;
        this.furnitureToMakeCollection = furnitureToMakeCollection;
    }

    public void buyRawMaterialsOfTheDay(int day, Vendor vendor) {
        for (int k = 0; k < this.rawMaterialsToBuyList.size(); k++) { // get buy list of the day
            String[] buyList = this.rawMaterialsToBuyList.get(k);
            if (day == Integer.valueOf(buyList[0])) {
                List<RawMaterial> vendorPossessionList = vendor.getRawMaterialPossessionList();
                for (int m = 1; m < buyList.length; m += 2) {
                    String materialToBuy = buyList[m];
                    int buyCount = Integer.valueOf(buyList[m + 1]); // get RawMaterial and count pair

                    boolean materialsAreBought = false;
                    int i = 0;
                    int[] indicesOfItemsToBeRemovedFromVendor = new int[buyCount];
                    while (!materialsAreBought) {
                        RawMaterial rawMaterial = vendorPossessionList.get(i);
                        if (materialToBuy.equals(rawMaterial.getMaterialCode())) {
                            indicesOfItemsToBeRemovedFromVendor[buyCount - 1] = i;
                            this.rawMaterialCollection.push(rawMaterial);
                            buyCount -= 1;
                            if (buyCount == 0)
                                materialsAreBought = true;
                        }
                        i++;
                    }
                    for (int j = 0; j < indicesOfItemsToBeRemovedFromVendor.length; j++) { // remove the items from the
                                                                                           // vendor that are bought
                        vendorPossessionList.remove(indicesOfItemsToBeRemovedFromVendor[j]);
                    }
                }
                vendor.setRawMaterialPossessionList(vendorPossessionList);
                return; // bought the items of the day
            }
        }

    }

    // public void printTotalExpenseAndIncome(int day) {
    // for (int i < 0; i < )
    // }

    public void produceFurniture(int day) {
        Map<String, String[]> furniturePartsMap = Furniture.getFurniturePartsMap();

        // get list of the furnitures for the day
        List<String[]> furnituresToMake = furnitureToMakeCollection.getFurnituresToProduce(day);  
        for (int j = 0; j < furnituresToMake.size(); j++) {
            String[] furnituresToMakeForTheDay = furnituresToMake.get(j);
            for (int m = 0; m < furnituresToMakeForTheDay.length; m += 2) {
                String idOfFurnitureToBeProduced = furnituresToMakeForTheDay[m];
                int produceCount = Integer.valueOf(furnituresToMakeForTheDay[m + 1]);
                if (produceCount == 0)
                    continue;

                char c = idOfFurnitureToBeProduced.charAt(0);
                String[] neededRawMaterialsArray = furniturePartsMap.get(idOfFurnitureToBeProduced);

                while (Integer.valueOf(furnituresToMakeForTheDay[m + 1]) > 0) {
                    if (this.rawMaterialCollection.containsAll(neededRawMaterialsArray)) {
                        double quality = calculateQuality(
                                fetchRawMaterialsToUseFromRawMaterialCollection(neededRawMaterialsArray));

                        addFurnitureToFurnitureList(c, idOfFurnitureToBeProduced, quality);
                        furnituresToMakeForTheDay[m + 1] = String.valueOf(--produceCount);
                    } else { // skip the day if the furniture cannot be produced
                        return;
                    }
                }
            }
        }
    }

    private List<RawMaterial> fetchRawMaterialsToUseFromRawMaterialCollection(String[] neededRawMaterialsArray) {
        List<RawMaterial> rawMaterialsToUse = new ArrayList<RawMaterial>();

        for (int i = 0; i < neededRawMaterialsArray.length; i += 2) {
            int rawMaterialCount = Integer.valueOf(neededRawMaterialsArray[i + 1]);
            for (int j = 0; j < rawMaterialCount; j++) {
                rawMaterialsToUse.add(this.rawMaterialCollection.pop(neededRawMaterialsArray[i]));
            }
        }
        return rawMaterialsToUse;
    }

    private double calculateQuality(List<RawMaterial> rawMaterialsToUse) {
        double numerator = 0;
        double denominator = 0;
        Map<String, Integer> rawMaterialVolumeMap = RawMaterial.getRawMaterialVolumeMap();
        for (RawMaterial rawMaterial : rawMaterialsToUse) {
            int volume = rawMaterialVolumeMap.get(rawMaterial.getMaterialCode());
            numerator += rawMaterial.getQuality() * volume;
            denominator += volume;
        }
        double quality = numerator / denominator;
        return quality;
    }

    private void addFurnitureToFurnitureList(char c, String idOfFurnitureToBeProduced, double quality) {
        switch (c) {
            case 'T':
                this.furnitureList.add(new Table(idOfFurnitureToBeProduced, quality));
                break;
            case 'S':
                this.furnitureList.add(new Shelf(idOfFurnitureToBeProduced, quality));
                break;
            case 'W':
                this.furnitureList.add(new Wardrobe(idOfFurnitureToBeProduced, quality));
                break;
            default:
                break;
        }
    }
}
