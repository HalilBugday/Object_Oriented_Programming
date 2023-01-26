package collections;

import java.util.ArrayList;
import java.util.List;

public class FurnitureToMakeQueue implements FurnitureToMakeCollection {
    private List<String[]> furnitureToMakeQueue;

    public FurnitureToMakeQueue() {
        this.furnitureToMakeQueue = new ArrayList<String[]>();
    }

    public FurnitureToMakeQueue(List<String[]> furnitureToMakeList) {
        this.furnitureToMakeQueue = new ArrayList<String[]>(furnitureToMakeList);
    }
    
    public List<String[]> getFurnituresToProduce(int day) {
        if(furnitureToMakeQueue.size() < day)
            day = furnitureToMakeQueue.size();
            
        List<String[]> listToReturn = new ArrayList<>();
        for (int i = 0; i < day; i++) {
            listToReturn.add(this.furnitureToMakeQueue.get(i));
        }
        return listToReturn;
    }

    public int size() {
        return this.furnitureToMakeQueue.size();
    }

    public void remove(int i) {
        this.furnitureToMakeQueue.remove(i);
    }
}