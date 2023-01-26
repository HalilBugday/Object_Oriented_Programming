package collections;

import java.util.List;

public interface FurnitureToMakeCollection {
    public List<String[]> getFurnituresToProduce(int day);
    public int size();
    public void remove(int i);
}
