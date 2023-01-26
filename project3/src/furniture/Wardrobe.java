package furniture;

public class Wardrobe extends Furniture{
    
    private static final int PROFIT_MARGIN = 320;
    
    public Wardrobe(){
        super();
    }

    public Wardrobe(String furnitureCode, double furnitureQuality){
        super(furnitureCode, furnitureQuality);
    }
    
    public Wardrobe(Wardrobe aWardrobe) {
        super(aWardrobe);
    }

    public int getProfitMargin(){
        return PROFIT_MARGIN;
    }

    public boolean equals(Wardrobe aWardrobe) {
        return super.equals(aWardrobe);
    }
    
    public boolean equals(Object object) {
        return super.equals(object);
    }

    public Wardrobe clone() {
        return new Wardrobe(this);
    }
    
    public String toString(){
        String toString = super.toString() + "Profit Margin: " + PROFIT_MARGIN;
        return toString;
    }
}