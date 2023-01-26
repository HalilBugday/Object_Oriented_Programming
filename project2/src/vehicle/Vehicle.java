package vehicle;
/*The parent class with setter getter methods and the overriden tostring and equals methods. 
    Also, since it is a parent class, calculateSCT and CalculateTotalPrice are added to be overridden.
    */

public class Vehicle {
    private String vehicleId;
    private String monthOfSale;
    private String cityOfSale;
    private int productionYear;
    private float vat;

    
    public Vehicle() {
        this.vehicleId = "";
        this.monthOfSale = "";
        this.cityOfSale = "";
        this.productionYear = 0;
        this.vat = 0f;
    }

    public Vehicle(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, float vat) {
        this.vehicleId = vehicleId;
        this.monthOfSale = monthOfSale;
        this.cityOfSale = cityOfSale;
        this.productionYear = productionYear;
        this.vat = vat;
    }

    public Vehicle(Vehicle aVehicle) {
        this.vehicleId = aVehicle.getVehicleId();
        this.monthOfSale = aVehicle.getMonthOfSale();
        this.cityOfSale = aVehicle.getCityOfSale();
        this.productionYear = aVehicle.getProductionYear();
        this.vat = aVehicle.getVat();
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMonthOfSale() {
        return this.monthOfSale;
    }

    public void setMonthOfSale(String monthOfSale) {
        this.monthOfSale = monthOfSale;
    }

    public String getCityOfSale() {
        return this.cityOfSale;
    }

    public void setCityOfSale(String cityOfSale) {
        this.cityOfSale = cityOfSale;
    }

    public int getProductionYear() {
        return this.productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public float getVat() {
        return this.vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public String toString() {
        String toString = "Vehicle: " + getClass() + " Vehicle ID: " + this.vehicleId + " Month: " + this.monthOfSale
                + " City: " + this.cityOfSale + " Production Year: " + this.productionYear +
                 " SCT: "  + this.calculateSCT()  + "\n The Total Price paid for " + this.getVehicleId() + " is: "  + this.calculateTotalPrice() + " TL";
        return toString;
    }

    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        Vehicle aVehicle = (Vehicle) object;
        return this.vehicleId.equals(aVehicle.getVehicleId())
                && this.monthOfSale.equals(aVehicle.getMonthOfSale())
                && this.cityOfSale.equals(aVehicle.getCityOfSale())
                && this.productionYear == aVehicle.getProductionYear()
                && this.vat == aVehicle.getVat();
    }

    /**
    Returns -1 for error check */

    public float calculateSCT() {
        return -1;
    }

    /**
    Returns -1 for error check */

    public float calculateTotalPrice() {
        return -1;
    }
}
