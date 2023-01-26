package rawMaterial;

import java.util.ArrayList;
import java.util.List;

import collections.RawMaterialCollection;

public class RawMaterialStack implements RawMaterialCollection {
    private List<RawMaterial> rawMaterialStack;

    public RawMaterialStack() {
        this.rawMaterialStack = new ArrayList<RawMaterial>();
    }

    public RawMaterialStack(List<RawMaterial> rawMaterialList) {
        this.rawMaterialStack = new ArrayList<RawMaterial>(rawMaterialList);
    }

    // TODO should we add copy constructor, if yes, how YES

    @Override
    public void push(RawMaterial rawMaterial) {
        rawMaterialStack.add(0, rawMaterial);
    }

    @Override
    public RawMaterial pop(String rawMaterialId) {
        for (int i = 0; i < this.rawMaterialStack.size(); i++) {
            RawMaterial rawMaterial = rawMaterialStack.get(i);
            if (rawMaterial.getMaterialCode().equals(rawMaterialId)) {
                rawMaterialStack.remove(i);
                return rawMaterial;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return rawMaterialStack.size();
    }

    @Override
    public boolean isEmpty() {
        return rawMaterialStack.isEmpty();
    }

    @Override
    public RawMaterial peek() {
        return rawMaterialStack.get(0);
    }

    @Override
    public int indexOf(RawMaterial rawMaterial) {
        return rawMaterialStack.indexOf(rawMaterial);
    }

    public boolean contains(String id, int count) {

        int totalCountOfRawMaterialWithId = 0;
        for (RawMaterial rawMaterial : rawMaterialStack) {
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
        for(RawMaterial rawMaterial : rawMaterialStack){
            toString = rawMaterial.toString();
        }
        return toString;
    }


}
