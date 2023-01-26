package furniture;

public class Shelf extends Furniture {
    private static final int PROFIT_MARGIN = 280;

    public Shelf() {
        super();
    }

    public Shelf(String furnitureCode, double furnitureQuality) {
        super(furnitureCode, furnitureQuality);
    }

    public Shelf(Shelf aShelf) {
        super(aShelf);
    }

    public int getProfitMargin() {
        return PROFIT_MARGIN;
    }

    public boolean equals(Furniture aFurniture) {
        return super.equals(aFurniture);
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public String toString() {
        String toString = super.toString() + "Profit Margin: " + PROFIT_MARGIN;
        return toString;
    }

    public Shelf clone() {
        return new Shelf(this);
    }
}