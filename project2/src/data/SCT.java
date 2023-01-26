/** Class to calculate SCT values of different vehicles. 
All methods return a negative value
in case the case condition is not met.
 */

package data;

public class SCT {

    public static float getProductionYearSCT(int productionYear) {
        if (productionYear >= 2001 && productionYear <= 2008)
            return 1f;
        if (productionYear >= 2012 && productionYear <= 2017)
            return 1.2f;
        if (productionYear >= 2018 && productionYear <= 2022)
            return 1.6f;
        return -1f;
    }

    public static float getMonthOfSaleSCT(String monthOfSale) {

        switch (monthOfSale.toLowerCase()) {
            case "january":
                return 0.3f;
            case "may":
                return 0.4f;
            case "august":
                return 0.5f;
            case "october":
                return 0.6f;
            case "december":
                return 0.7f;
            default:
                return -1;
        }
    }

    public static float getCityOfSaleSCT(String cityOfSale) {
        switch (cityOfSale.toLowerCase()) {
            case "izmir":
                return 0.1f;
            case "istanbul":
                return 0.3f;
            case "ankara":
                return 0.2f;
            default:
                return -1;
        }
    }

    public static float getRoofTypeSCT(String roofType) {
        switch (roofType.toLowerCase()) {
            case "regular":
                return 0.5f;
            case "moonroof":
                return 0.6f;
            case "sunroof":
                return 0.8f;
            default:
                return -1;
        }
    }

    public static float getCityModeSCT(boolean hasCityMode) {
        if (hasCityMode)
            return 0.15f;
        return 0.1f;
    }

    public static float getNumberOfSeatsSCT(int numberOfSeats) {
        switch (numberOfSeats) {
            case 4:
                return 0.1f;
            case 5:
                return 0.4f;
            case 6:
                return 0.6f;
            case 7:
                return 0.8f;
            default:
                return -1;
        }
    }

    public static float getCabTypeSCT(String cabType) {
        switch (cabType.toLowerCase()) {
            case "regular":
                return 2.5f;
            case "extended":
                return 2.8f;
            case "crew":
                return 3f;
            default:
                return -1;
        }
    }

    public static float getChainTypeSCT(String chainType) {
        switch (chainType.toLowerCase()) {
            case "derailleur":
                return 1.1f;
            case "onechain":
                return 1.2f;
            case "doublechain":
                return 1.3f;
            default:
                return -1;
        }
    }

    public static float getTruckBedTypeSCT(String truckBedType) {
        switch (truckBedType.toLowerCase()) {
            case "regular":
                return 0.5f;
            case "tanker":
                return 0.8f;
            case "trailer":
                return 1f;
            default:
                return -1;
        }
    }

    public static float getSeatPostSCT(String seatPost) {
        switch (seatPost.toLowerCase()) {
            case "carbonfiber":
                return 0.8f;
            case "steel":
                return 0.7f;
            case "aluminum":
                return 0.9f;
            case "titanium":
                return 0.6f;
            default:
                return -1;
        }
    }

}
