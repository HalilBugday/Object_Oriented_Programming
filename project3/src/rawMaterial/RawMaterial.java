package rawMaterial;

import java.util.HashMap;
import java.util.Map;

import utils.FileIO;

public class RawMaterial {
    private String materialCode;
    private int quality;
    private static Map<String, Integer> rawMaterialVolumeMap = new HashMap<String, Integer>();
    private static Map<String, Integer> rawMaterialCostMap = new HashMap<String, Integer>();

    public RawMaterial() {
        this.materialCode = "";
        this.quality = -1;
    }

    public RawMaterial(String materialCode, int quality) {
        this.materialCode = materialCode;
        this.quality = quality;
    }

    public RawMaterial(RawMaterial otherRawMaterial) {
        this.materialCode = otherRawMaterial.getMaterialCode();
        this.quality = otherRawMaterial.getQuality();
    }

    public String getMaterialCode() {
        return this.materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public int getQuality() {
        return this.quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public static Map<String, Integer> getRawMaterialCostMap() {
        return new HashMap<String, Integer>(rawMaterialCostMap);
    }

    public static Map<String, Integer> getRawMaterialVolumeMap() {
        return new HashMap<String, Integer>(rawMaterialVolumeMap);
    }

    public static void setRawMaterialCostMap(Map<String, Integer> otherRawMaterialCostMap) {
        rawMaterialCostMap = new HashMap<String, Integer>(otherRawMaterialCostMap);
    }

    public static void setRawMaterialVolumeMap(Map<String, Integer> otherRawMaterialVolumeMap) {
        rawMaterialVolumeMap = new HashMap<String, Integer>(otherRawMaterialVolumeMap);
    }

    static {
        FileIO.getRawMaterialPropertiesFromCSVFile("src/data/RawMaterialProperties.csv");
    }

    public String toString() {
        String toString = "Material Code: " + this.materialCode + "Quality: " + this.quality;
        return toString;
    }

    public boolean equals(RawMaterial aRawMaterial) {
        return (this.materialCode.equals(aRawMaterial.getMaterialCode())
                && this.quality == aRawMaterial.getQuality());
    }

    public RawMaterial clone() {
        return new RawMaterial(this);
    }
}
