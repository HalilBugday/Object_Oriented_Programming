package vendor;

import java.util.ArrayList;
import java.util.List;

import rawMaterial.RawMaterial;

public class Vendor {
    private List<RawMaterial> rawMaterialPossessionList;

    public Vendor() {
        this.rawMaterialPossessionList = new ArrayList<RawMaterial>();
    }

    public Vendor(List<RawMaterial> rawMaterialPossessionList) {
        this.rawMaterialPossessionList = rawMaterialPossessionList;
    }


    public List<RawMaterial> getRawMaterialPossessionList() {
        return new ArrayList<RawMaterial>(this.rawMaterialPossessionList);
    }

    public void setRawMaterialPossessionList(List<RawMaterial> rawMaterialPossessionList) {
        this.rawMaterialPossessionList = new ArrayList<RawMaterial>(rawMaterialPossessionList);
    }
    

}
