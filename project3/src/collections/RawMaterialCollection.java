package collections;

import rawMaterial.RawMaterial;

public interface RawMaterialCollection {
    public void push(RawMaterial rawMaterial);

    public RawMaterial pop(String rawMaterialId);

    public int getSize();

    public boolean isEmpty();

    public RawMaterial peek();

    public int indexOf(RawMaterial rawMaterial);

    /**
     * Returns true if the collection contains the raw material with the given id at
     * least "count" amount of times
     * 
     * @param id    id of raw material
     * @param count count of raw material
     * @return boolean
     **/
    public boolean contains(String id, int count);

    /**
     * Returns true if the collection contains all of the raw materials inside
     * the String array, String array is in the form of {materialId1,
     * materialCount1, materialId2, materialIdCount2...}
     **/

    public boolean containsAll(String[] rawMaterialArray);
}
