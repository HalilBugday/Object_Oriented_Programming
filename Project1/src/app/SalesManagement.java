package app;

public class SalesManagement { // Bundan bir tane yaratmak muhtemelen yeterli olacaktır
    private Sales[][] salesArray; // Two-dimensional array that holds Sales objects for each Supplier.
                                  // For 3rd supplier’s 7th Sales, it is [2][6].
                                  // [[s1][s2][s3]]

    public SalesManagement(Sales[][] salesArray) {
        this.salesArray = salesArray;
    }

    public Sales[][] getSalesArray() {
        return salesArray;
    }

    public void setSalesArray(Sales[][] salesArray) {
        this.salesArray = salesArray;
    }
}
