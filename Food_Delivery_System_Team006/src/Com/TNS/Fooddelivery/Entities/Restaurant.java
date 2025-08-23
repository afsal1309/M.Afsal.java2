package Com.TNS.Fooddelivery.Entities;

import java.util.*;

public class Restaurant {
    private int id;
    private String name;
    private List<FoodItem> menu = new ArrayList<>();

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public List<FoodItem> getMenu() { return menu; }

    // Methods
    public void addFoodItem(FoodItem f) { menu.add(f); }
    public void removeFoodItem(int fid) { menu.removeIf(f -> f.getId() == fid); }

    @Override
    public String toString() {
        return "Restaurant ID: " + id + " | Name: " + name;
    }

	public Map<Integer,Restaurant> getFoodItems() {
		// TODO Auto-generated method stub
		return null;
	}
}

