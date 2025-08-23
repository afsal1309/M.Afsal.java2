package Com.TNS.Fooddelivery.Entities;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class FoodDeliverySystem {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Restaurant> restaurants = new HashMap<>();
    static Map<Integer, Customer> customers = new HashMap<>();
    static Map<Integer, Order> orders = new HashMap<>();
    static List<DeliveryPerson> deliveryPeople = new ArrayList<>();

    static int restaurantCounter = 1001, customerCounter = 2001, orderCounter = 3001, deliveryCounter = 4001;

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static void main(String[] args) {
        System.out.println("🚀 Food Delivery System Started");

        while (true) {
            try {
                System.out.println("\n===== FOOD DELIVERY SYSTEM =====");
                System.out.println("1. Admin Menu");
                System.out.println("2. Customer Menu");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1: adminMenu(); break;
                    case 2: customerMenu(); break;
                    case 3: System.out.println("🙏 Goodbye!"); return;
                    default: System.out.println("❌ Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠ Invalid input! Please enter numbers only.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("⚠ Unexpected Error: " + e.getMessage());
            }
        }
    }

    // ---------------- ADMIN MENU ----------------
    private static void adminMenu() {
        while (true) {
            try {
                System.out.println("\n--- Admin Menu ---");
                System.out.println("1. Add Restaurant");
                System.out.println("2. Add Food Item");
                System.out.println("3. Remove Food Item");
                System.out.println("4. View Restaurants");
                System.out.println("5. View Orders");
                System.out.println("6. Add Delivery Person");
                System.out.println("7. Assign Delivery Person to Order");
                System.out.println("8. Back");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter Restaurant Name: ");
                        String rname = sc.next();
                        restaurants.put(restaurantCounter, new Restaurant(restaurantCounter, rname));
                        System.out.println("✅ Restaurant Added with ID " + restaurantCounter + " at " + getIST());
                        restaurantCounter++;
                        break;

                    case 2:
                        System.out.print("Enter Restaurant ID: ");
                        int rid = sc.nextInt();
                        Restaurant r = restaurants.get(rid);
                        if (r == null) throw new NullPointerException("Restaurant not found!");
                        System.out.print("Enter Food Name: ");
                        String fname = sc.next();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        if (price <= 0) throw new ArithmeticException("Price must be greater than zero!");
                        r.addFoodItem(new FoodItem(r.getMenu().size() + 1, fname, price));
                        System.out.println("✅ Food Item Added at " + getIST());
                        break;

                    case 3:
                        System.out.print("Enter Restaurant ID: ");
                        rid = sc.nextInt();
                        r = restaurants.get(rid);
                        if (r == null) throw new NullPointerException("Restaurant not found!");
                        if (r.getMenu().isEmpty()) { System.out.println("No food items to remove."); break; }
                        for (FoodItem f : r.getMenu()) System.out.println(f);
                        System.out.print("Enter Food ID to Remove: ");
                        int fid = sc.nextInt();
                        r.removeFoodItem(fid);
                        System.out.println("✅ Food Removed at " + getIST());
                        break;

                    case 4:
                        if(restaurants.isEmpty()) System.out.println("No restaurants added yet.");
                        else {
                            for (Restaurant res : restaurants.values()) {
                                System.out.println(res);
                                for (FoodItem f : res.getMenu()) System.out.println("   " + f);
                            }
                        }
                        break;

                    case 5:
                        if(orders.isEmpty()) System.out.println("No orders placed yet.");
                        else {
                            for (Order o : orders.values()) {
                                System.out.println(
                                    o + " | Customer: " + o.getCustomer().getName() +
                                    " | Delivery: " + (o.getDeliveryPerson() != null ? o.getDeliveryPerson().getName() + " (" + o.getDeliveryPerson().getContact() + ")" : "Not Assigned") +
                                    " | Status: " + o.getStatus() +
                                    " | Time: " + getIST()
                                );
                            }
                        }
                        break;

                    case 6:
                        System.out.print("Enter Delivery Person Name: ");
                        String dname = sc.next();
                        System.out.print("Enter Contact Number: ");
                        long dcontact = sc.nextLong();
                        deliveryPeople.add(new DeliveryPerson(deliveryCounter++, dname, dcontact));
                        System.out.println("✅ Delivery Person Added at " + getIST());
                        break;

                    case 7:
                        try {
                            if (orders.isEmpty()) {
                                System.out.println("No orders to assign.");
                                break;
                            }
                            if (deliveryPeople.isEmpty()) {
                                System.out.println("No delivery person available.");
                                break;
                            }

                            System.out.print("Enter Order ID: ");
                            int oid = sc.nextInt();
                            Order orderToAssign = orders.get(oid);
                            if (orderToAssign == null) {
                                System.out.println("Order not found.");
                                break;
                            }

                            System.out.println("Available Delivery Persons:");
                            for (DeliveryPerson dPerson : deliveryPeople) {
                                System.out.println(dPerson);
                            }

                            System.out.print("Enter Delivery Person ID to Assign: ");
                            int did = sc.nextInt();
                            DeliveryPerson assignedPerson = deliveryPeople.stream()
                                    .filter(d -> d.getId() == did)
                                    .findFirst()
                                    .orElse(null);

                            if (assignedPerson == null) {
                                System.out.println("Delivery Person not found.");
                                break;
                            }

                            orderToAssign.setDeliveryPerson(assignedPerson);
                            orderToAssign.setStatus("Out for delivery with " + assignedPerson.getName());
                            orderToAssign.setDeliveryTime(getIST()); // Make sure getIST() returns current IST time

                            System.out.println("✅ Delivery Person Assigned. Order will be delivered at " + orderToAssign.getDeliveryTime());
                        } catch (InputMismatchException e) {
                            System.out.println("⚠ Please enter a valid number.");
                            sc.nextLine(); // clear buffer
                        } catch (Exception e) {
                            System.out.println("⚠ Error while assigning delivery: " + e.getMessage());
                        }
                        break;


                    case 8: return;
                    default: System.out.println("❌ Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("⚠ Please enter valid numeric input.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("⚠ Error: " + e.getMessage());
            }
        }
    }

    // ---------------- CUSTOMER MENU ----------------
    private static void customerMenu() {
        try {
            System.out.print("Enter Your Name: ");
            String cname = sc.next();
            System.out.print("Enter Contact: ");
            long contact = sc.nextLong();
            Customer c = new Customer(customerCounter++, cname, contact);
            customers.put(c.getId(), c);

            while (true) {
                try {
                    System.out.println("\n--- Customer Menu ---");
                    System.out.println("1. View Restaurants & Menu");
                    System.out.println("2. Add to Cart");
                    System.out.println("3. View Cart");
                    System.out.println("4. Place Order");
                    System.out.println("5. Track Orders");
                    System.out.println("6. Back");
                    System.out.print("Enter choice: ");
                    int ch = sc.nextInt();

                    switch (ch) {
                        case 1:
                            if(restaurants.isEmpty()) System.out.println("No restaurants available. Ask admin to add restaurants.");
                            else {
                                for (Restaurant r : restaurants.values()) {
                                    System.out.println(r);
                                    for (FoodItem f : r.getMenu()) System.out.println("   " + f);
                                }
                            }
                            break;

                        case 2:
                            System.out.print("Enter Restaurant ID: ");
                            int rid = sc.nextInt();
                            Restaurant r = restaurants.get(rid);
                            if (r == null) throw new NullPointerException("Restaurant not found!");
                            if(r.getMenu().isEmpty()) { System.out.println("No food items available in this restaurant."); break; }
                            for (FoodItem f : r.getMenu()) System.out.println(f);
                            System.out.print("Enter Food ID: ");
                            int fid = sc.nextInt();
                            System.out.print("Enter Quantity: ");
                            int qty = sc.nextInt();
                            if (qty <= 0) throw new ArithmeticException("Quantity must be positive!");
                            FoodItem item = r.getMenu().stream().filter(f -> f.getId() == fid).findFirst().orElse(null);
                            if (item != null) { c.addItem(item, qty); System.out.println("✅ Added to Cart at " + getIST()); }
                            else { System.out.println("Invalid Food ID"); }
                            break;

                        case 3:
                            System.out.println(c.getCart());
                            break;

                        case 4:
                            if (c.getCart().getItems().isEmpty()) { System.out.println("❌ Your cart is empty!"); continue; }
                            Order o = new Order(orderCounter, c, c.getCart().getItems());
                            orders.put(orderCounter, o);
                            c.getCart().clearCart();
                            System.out.println("✅ Order Placed! Your Order ID = " + orderCounter + " at " + getIST());
                            orderCounter++;
                            break;

                        case 5:
                            boolean found = false;
                            for (Order ord : orders.values()) {
                                if (ord.getCustomer().getId() == c.getId()) {
                                    found = true;
                                    String status = ord.getStatus();
                                    if(ord.getDeliveryTime()!=null && status.contains("Out for delivery")) {
                                        status = "✅ Order Delivered Successfully at " + ord.getDeliveryTime();
                                    }
                                    System.out.println(ord + " | Delivery: " + 
                                        (ord.getDeliveryPerson() != null ? ord.getDeliveryPerson().getName() + " (" + ord.getDeliveryPerson().getContact() + ")" : "Not Assigned") +
                                        " | Status: " + status);
                                }
                            }
                            if(!found) System.out.println("No orders found for you.");
                            break;

                        case 6: return;
                        default: System.out.println("❌ Invalid choice!");
                    }

                } catch (Exception e) { System.out.println("⚠ Error: " + e.getMessage()); sc.nextLine(); }
            }
        } catch (Exception e) { System.out.println("⚠ Error in customer registration: " + e.getMessage()); }
    }

    private static String getIST() { return ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).format(dtf); }
}
