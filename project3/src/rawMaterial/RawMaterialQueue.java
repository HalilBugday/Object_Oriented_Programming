package rawMaterial;

import java.util.ArrayList;
import java.util.List;

import collections.RawMaterialCollection;

public class RawMaterialQueue implements RawMaterialCollection {
    private List<RawMaterial> rawMaterialQueue;

    public RawMaterialQueue() {
        this.rawMaterialQueue = new ArrayList<RawMaterial>();
    }

    public RawMaterialQueue(List<RawMaterial> rawMaterialList) {
        this.rawMaterialQueue = new ArrayList<RawMaterial>(rawMaterialList);
    }

    @Override
    public void push(RawMaterial rawMaterial) {
        rawMaterialQueue.add(rawMaterial);
    }

    @Override
    public RawMaterial pop(String rawMaterialId) {
        for (int i = 0; i < this.rawMaterialQueue.size(); i++) {
            RawMaterial rawMaterial = rawMaterialQueue.get(i);
            if(rawMaterial.getMaterialCode().equals(rawMaterialId)) {
                rawMaterialQueue.remove(i);
                return rawMaterial;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return rawMaterialQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return rawMaterialQueue.isEmpty();
    }

    @Override
    public RawMaterial peek() {
        return rawMaterialQueue.get(0);
    }

    @Override
    public int indexOf(RawMaterial rawMaterial) {
        return rawMaterialQueue.indexOf(rawMaterial);
    }

    public boolean contains(String id, int count) {

        int totalCountOfRawMaterialWithId = 0;
        for (RawMaterial rawMaterial : rawMaterialQueue) {
            if (rawMaterial.getMaterialCode().equals(id))
                totalCountOfRawMaterialWithId += 1;
            if (totalCountOfRawMaterialWithId == count)
                return true;
        }
        return false;
    }

    public boolean containsAll(String[] rawMaterialArray) {

        for (int i = 0; i < rawMaterialArray.length; i += 2) {
            if (!contains(rawMaterialArray[i], Integer.valueOf(rawMaterialArray[i + 1]))) {
                return false;
            }
        }
        return true;
    }

    public String toString(){
        String toString ="";
        for(RawMaterial rawMaterial : rawMaterialQueue){
            toString = rawMaterial.toString();
        }
        return toString;
    }

    

}
