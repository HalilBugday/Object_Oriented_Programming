package vehicle.automobile;

import vehicle.Vehicle;

/*Another parent class, but also the child of the Vehicle Class.
This class has setter and getter methods with overriden toString and
equals methods. Since it is a parent class, it includes calculateSCT and calculateTotalPrice methods to be overridden.
*/
public class Automobile extends Vehicle {
    private float engineVolume;
    private static final int BASE_PRICE = 200000;

    public Automobile() {
        super();
        this.engineVolume = 0f;
    }

    public Automobile(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, float vat,
            float engineVolume) {
        super(vehicleId, monthOfSale, cityOfSale, productionYear, vat);
        this.engineVolume = engineVolume;
    }

    public Automobile(Automobile aAutomobile) {
        super(aAutomobile);
        this.engineVolume = aAutomobile.getEngineVolume();
    }

    public float getEngineVolume() {
        return this.engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getBasePrice() {
        return BASE_PRICE;
    }

    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        Automobile aAutomobile = (Automobile) object;
        return super.equals(aAutomobile) && this.engineVolume == aAutomobile.getEngineVolume();
    }

    public String toString() {
        String toString = super.toString();
        return toString;
    }

    public float calculateSCT() {
        return 0f;
    }

    public float calculateTotalPrice() {
        return (BASE_PRICE * (1 + this.calculateSCT() * 0.8f) + (1 + this.getVat() / 100));
    }

}
