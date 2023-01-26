package vehicle.automobile;

import data.SCT;

public class Sedan extends Automobile {
    private String roofType;

    public Sedan() {
        super();
        this.roofType = "";
    }

    public Sedan(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, float vat,
            float engineVolume, String roofType) {
        super(vehicleId, monthOfSale, cityOfSale, productionYear, vat, engineVolume);
        this.roofType = roofType;
    }

    public Sedan(Sedan aSedan) {
        super(aSedan);
        this.roofType = aSedan.getRoofType();
    }

    public String getRoofType() {
        return this.roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        Sedan aSedan = (Sedan) object;
        return super.equals(aSedan)
                && this.roofType.equals(aSedan.getRoofType());
    }

    public String toString() {
        String toString = super.toString();
        return toString;
    }

    public float calculateSCT() {
        return this.getEngineVolume() * 0.2f * SCT.getRoofTypeSCT(roofType) / this.getProductionYear();
    }
}
