package vehicle.bicycle;

import data.SCT;
import vehicle.Vehicle;

public class Bicycle extends Vehicle {
    private String seatPost;
    private String chainType;
    private static final int BASE_PRICE = 10000;

    public Bicycle() {
        super();
        this.seatPost = "";
        this.chainType = "";
    }

    public Bicycle(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, float vat,
            String chainType,
            String seatPost) {
        super(vehicleId, monthOfSale, cityOfSale, productionYear, vat);
        this.seatPost = seatPost;
        this.chainType = chainType;
    }

    public Bicycle(Bicycle aBicycle) {
        super(aBicycle);
        this.seatPost = aBicycle.getSeatPost();
        this.chainType = aBicycle.getChainType();
    }

    public String getSeatPost() {
        return this.seatPost;
    }

    public void setSeatPost(String seatPost) {
        this.seatPost = seatPost;
    }

    public String getChainType() {
        return this.chainType;
    }

    public void setChainType(String chainType) {
        this.chainType = chainType;
    }

    public int getBasePrice(){
        return BASE_PRICE;
    }

    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        Bicycle aBicycle = (Bicycle) object;
        return super.equals(aBicycle)
                && this.seatPost.equals(aBicycle.getSeatPost())
                && this.chainType.equals(aBicycle.getChainType());
    }

    public String toString() {
        String toString = super.toString();
        return toString;
    }

    public float calculateSCT() {
        return SCT.getChainTypeSCT(chainType) * SCT.getSeatPostSCT(seatPost) * 0.1f
                + SCT.getMonthOfSaleSCT(this.getMonthOfSale());
    }

    public float calculateTotalPrice(){
        return (BASE_PRICE * 0.9f) * (1 + this.calculateSCT()) + (1 + this.getVat()/100);
    }
}
