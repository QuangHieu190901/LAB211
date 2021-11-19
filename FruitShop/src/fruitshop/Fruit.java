package fruitshop;

public class Fruit {
    
    String fruitID;
    String fruitName;
    double fruitPrice;
    int fruitQuantity;
    String fruitOrigin;

    public Fruit(String fruitID, String fruitName, double fruitPrice, int fruitQuantity, String fruitOrigin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.fruitQuantity = fruitQuantity;
        this.fruitOrigin = fruitOrigin;
    }

    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    public String getFruitorigin() {
        return fruitOrigin;
    }

    public void setFruitorigin(String fruitOrigin) {
        this.fruitOrigin = fruitOrigin;
    }
    
}
