package collections;

import java.util.ArrayList;
import java.util.List;

public class FurnitureToMakeStack implements FurnitureToMakeCollection {
    private List<String[]> furnitureToMakeStack;

    public FurnitureToMakeStack() {
        this.furnitureToMakeStack = new ArrayList<String[]>();
    }

    /**
     * This method reverses the furnitures that are to be made for the day to
     * satisfy the logic of the stack. The last furniture in the list is put on top
     * of the list to be produced. 
     * */
    public FurnitureToMakeStack(List<String[]> furnitureToMakeList) {
        ArrayList<String[]> reversedListToReturn = new ArrayList<String[]>();
        for (int i = 0; i < furnitureToMakeList.size(); i++) {
            String[] furnituresToMakeForTheDay = furnitureToMakeList.get(i);
            int lengthOfFurnituresToMakeForTheDay = furnituresToMakeForTheDay.length;
            String[] reversedList = new String[lengthOfFurnituresToMakeForTheDay];
            int index = 0;
            for (int j = lengthOfFurnituresToMakeForTheDay - 2; j >= 0; j -= 2) {
                String idOfTheFurniture = furnituresToMakeForTheDay[j];
                String produceCount = furnituresToMakeForTheDay[j + 1];
                reversedList[index] = idOfTheFurniture;
                reversedList[index + 1] = produceCount;
                index += 2;
            }
            reversedListToReturn.add(reversedList);
        }
        this.furnitureToMakeStack = reversedListToReturn;
    }

    /**
     * This method returns the list of the furnitures to be made for the day.
     * The furnitures on the newest days are produced first.
     */
    public List<String[]> getFurnituresToProduce(int day) {
        if (furnitureToMakeStack.size() < day)
            day = furnitureToMakeStack.size();

        List<String[]> listToReturn = new ArrayList<>();
        for (int i = day - 1; i >= 0; i--) {
            listToReturn.add(this.furnitureToMakeStack.get(i));
        }
        return listToReturn;
    }

    public int size() {
        return this.furnitureToMakeStack.size();
    }

    public void remove(int i) {
        this.furnitureToMakeStack.remove(i);
    }
}
