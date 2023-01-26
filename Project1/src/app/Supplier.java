package app;

public class Supplier { // 3 tane supplier var, bunlar s1, s2, s3
    private Product[] productArray;

    public Supplier(Product[] productArray) {
        this.productArray = productArray;
    }

    public Product getProductById(String id) {
        for (int i = 0; i < productArray.length; i++) {
            if (productArray[i].getId().equals(id)) {
                return productArray[i];
            }
        }
        return null;
    }

    public Product[] getProductArray() {
        return productArray;
    }

    public void setProductArray(Product[] productArray) {
        this.productArray = productArray;
    }
}
