package furniture;

public class Table extends Furniture {

    private static final int PROFIT_MARGIN = 300;

    public Table() {
        super();
    }

    public Table(String furnitureCode, double furnitureQuality){
        super(furnitureCode, furnitureQuality);
    }

    public Table(Table aTable){
        super(aTable);
    }

    public int getProfitMargin() {
        return PROFIT_MARGIN;
    }

    public Table clone() {
        return new Table(this);
    }
    
    public String toString(){
        String toString = super.toString() + "Profit Margin: " + PROFIT_MARGIN;
        return toString;
    }

    public boolean equals(Table aTable) {
        return super.equals(aTable);
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }
}