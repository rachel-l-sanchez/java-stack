import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class Order {
    private String name;
    private boolean isReady;
    private double price;
    private String itemName;

    public double getOrderTotal(double price, int quantity, Item menuItem, ArrayList<Item> items) { 
        for (int i=0; i<=items.size(); i++) {
            if (items.equals(menuItem)) {
                this.price = price;
            }
        }
        double total = price * quantity;
        return total;
    }

    public Order(){
        this.name = "Guest";
    }

    public Order(String name, String itemName){
        this.name = name;
        this.itemName = itemName;
    }

    public void addItem(Item name, ArrayList<Item> items) {
        Collections.addAll(items);
    }

    public String getStatusMessage() {
        if (isReady == true) {
            return "Your order is ready";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon";
        }
    }

    public void orderReady (boolean isReady) {
        this.isReady = isReady;
    }

    String itemWithPrice;
    String itemWithPrice2;
    String output;
    public String display (ArrayList<Item> menu, int quantity, double price, String name, String menuItem, ArrayList<Item> items) {
        this.price = price;
        if (this.name == name) {
            String itemString = this.itemName;
            String itemWithPrice = itemString + " - " + this.price;
            String output = "Customer Name: " + this.name + "\n" + itemWithPrice;
            System.out.println(output);
            if (quantity > 1) {
                for (int i=0; i <quantity - 1; i++) {
                    String multipleString = itemString;
                    String itemWithPrice2 = multipleString + " - " + this.price;
                    System.out.println(itemWithPrice2);
                }
            }
        }
        double total = quantity * this.price;
        String output2 = "Total:" + total + "\n";
        return output2;
    }
  
}
