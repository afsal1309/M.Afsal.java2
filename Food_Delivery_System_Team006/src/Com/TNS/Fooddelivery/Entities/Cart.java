package Com.TNS.Fooddelivery.Entities;

import java.util.*;

public class Cart {
    private Map<FoodItem, Integer> items = new HashMap<>();

    // Getter
    public Map<FoodItem, Integer> getItems() { return items; }

    public void addItem(FoodItem f, int qty) {
        items.put(f, items.getOrDefault(f, 0) + qty);
    }

    public void clearCart() {
        items.clear();
    }

    @Override
    public String toString() {
        if (items.isEmpty()) return "Cart is Empty!";
        StringBuilder sb = new StringBuilder("Your Cart:\n");
        for (Map.Entry<FoodItem, Integer> e : items.entrySet()) {
            sb.append(e.getKey().getPrice())
              .append(" x ").append(e.getValue())
              .append(" = ₹").append(e.getKey().getPrice() * e.getValue())
              .append("\n");
        }
        return sb.toString();
    }
}
