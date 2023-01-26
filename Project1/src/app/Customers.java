package app;

public class Customers {
    private Customer[] customerArray;

    // constructor
    public Customers(Customer[] customerArray) {
        this.customerArray = customerArray;
    }

    public Customer getCustomerById(String id) {
        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getId().equals(id)) {
                return customerArray[i];
            }
        }

        return null;
    }

    public Customer[] getCustomerArray() {
        return this.customerArray;
    }

    public void setCustomerArray(Customer[] customerArray) {
        this.customerArray = customerArray;
    }

    public boolean equals(Customers aCustomers) {
        return false; // TODO: doldur
    }
}
