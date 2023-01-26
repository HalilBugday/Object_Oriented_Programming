package vehicle.automobile;

import data.SCT;

public class Hatchback extends Automobile {
    private boolean hasCityMode;

    public Hatchback() {
        super();
        this.hasCityMode = false;
    }

    public Hatchback(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, float vat,
            float engineVolume, boolean hasCityMode) {
        super(vehicleId, monthOfSale, cityOfSale, productionYear, vat, engineVolume);
        this.hasCityMode = hasCityMode;
    }

    public Hatchback(Hatchback aHatchbak) {
        super(aHatchbak);
        this.hasCityMode = aHatchbak.getHasCityMode();
    }

    public boolean getHasCityMode() {
        return this.hasCityMode;
    }

    public void setHasCityMode(boolean hasCityMode) {
        this.hasCityMode = hasCityMode;
    }

    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        Hatchback aHatchback = (Hatchback) object;
        return super.equals(aHatchback) && this.hasCityMode == aHatchback.getHasCityMode();
    }

    public String toString() {
        String toString = super.toString();
        return toString;
    }

    public float calculateSCT() {
        return this.getEngineVolume() * 0.3f * SCT.getProductionYearSCT(this.getProductionYear())
                + SCT.getCityModeSCT(this.hasCityMode);
    }
}
