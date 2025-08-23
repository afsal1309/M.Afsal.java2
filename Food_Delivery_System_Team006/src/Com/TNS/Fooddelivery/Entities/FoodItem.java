package Com.TNS.Fooddelivery.Entities;

public class FoodItem {
    private int id;
    private String name;
    private double price;

    public FoodItem(int foodCounter, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return id + ". " + name + " - ₹" + price;
    }
}

