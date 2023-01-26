package vehicle.automobile;

import data.SCT;

public class Minivan extends Automobile {
    private int numberOfSeats;

    public Minivan() {
        super();
        this.numberOfSeats = 0;
    }

    public Minivan(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, float vat,
            float engineVolume, int numberOfSeats) {
        super(vehicleId, monthOfSale, cityOfSale, productionYear, vat, engineVolume);
        this.numberOfSeats = numberOfSeats;
    }

    public Minivan(Minivan aMinivan) {
        super(aMinivan);
        this.numberOfSeats = aMinivan.getNumberOfSeats();
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        Minivan aMinivan = (Minivan) object;
        return super.equals(aMinivan) && this.numberOfSeats == aMinivan.getNumberOfSeats();
    }

    public String toString() {
        String toString = super.toString();
        return toString;
    }

    public float calculateSCT() {
        return (0.6f * SCT.getProductionYearSCT(this.getProductionYear()))
                / (this.getEngineVolume() + SCT.getNumberOfSeatsSCT(numberOfSeats));
    }
}
