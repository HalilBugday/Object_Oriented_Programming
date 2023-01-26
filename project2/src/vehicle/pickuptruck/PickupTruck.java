package vehicle.pickuptruck;

import data.SCT;
import vehicle.Vehicle;

public class PickupTruck extends Vehicle {
    private String cabType;
    private String bedType;
    private static final int BASE_PRICE = 250000;

    public PickupTruck() {
        super();
        this.cabType = "";
        this.bedType = "";
    }

    public PickupTruck(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, float vat,
            String cabType, String truckBedType) {
        super(vehicleId, monthOfSale, cityOfSale, productionYear, vat);
        this.cabType = cabType;
        this.bedType = truckBedType;
    }

    public PickupTruck(PickupTruck aPickupTruck) {
        super(aPickupTruck);
        this.cabType = aPickupTruck.getCabType();
        this.bedType = aPickupTruck.getTruckBedType();
    }

    public String getCabType() {
        return this.cabType;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    public String getTruckBedType() {
        return this.bedType;
    }

    public void setTruckBedType(String truckBedType) {
        this.bedType = truckBedType;
    }

    public int getBasePrice(){
        return BASE_PRICE;
    }

    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        PickupTruck aPickupTruck = (PickupTruck) object;
        return super.equals(aPickupTruck)
                && this.cabType.equals(aPickupTruck.getCabType())
                && this.bedType.equals(aPickupTruck.getTruckBedType());
    }

    public String toString() {
        String toString = super.toString();
        return toString;
    }

    public float calculateSCT() {
        return (SCT.getTruckBedTypeSCT(bedType) * SCT.getProductionYearSCT(this.getProductionYear()))
                / SCT.getCabTypeSCT(cabType);
    }

    public float calculateTotalPrice(){
        return BASE_PRICE * (1 + (this.calculateSCT() * 0.6f)) + (1 + this.getVat()/100);
    }
}
