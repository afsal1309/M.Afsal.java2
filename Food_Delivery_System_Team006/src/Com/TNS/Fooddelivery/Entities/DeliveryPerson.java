package Com.TNS.Fooddelivery.Entities;

public class DeliveryPerson {
    private int id;
    private String name;
    private long contact; // store contact number

    public DeliveryPerson(int id, String name, long contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public long getContact() { return contact; } // return the contact number

    @Override
    public String toString() {
        return name + " (ID: " + id + ", Contact: " + contact + ")";
    }
}
