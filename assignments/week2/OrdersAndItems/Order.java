import java.util.ArrayList;

public class Order {
    public String name;
    public double total;
    public boolean isReady;
    public ArrayList<Item>items;

    public void getOrderTotal(double price) { 
        this.total = price;
    }

    public void printPriceChart(ArrayList<Item> items) {
        Item product;
        for (int i=0; i<=items.size(); i++) {
            if (items.get(i).equals("capuccino")) {
                product = items.get(1);

            }
            if (items.get(i).equals("mocha")) {
                product = items.get(3);

            }
            if (items.get(i).equals("drip coffee")) {
                product = items.get(0);

            }
            if (items.get(i).equals("latte")) {
                product = items.get(2);
            }
        }
    }

    public void addCustomer (ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String name = System.console().readLine();
        System.out.println("Hello " + name);
        customers.add(name);
        System.out.println("There are " + (customers.size()) +"people in front of you");
    }
    

    public String orderName(String name) {
        this.name = name;
        return name;
    }

    public void orderReady (boolean isReady) {
        this.isReady = isReady;
    }

}
