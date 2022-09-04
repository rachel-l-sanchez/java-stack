import java.util.ArrayList;

public class OrderTest {
    public static void main(String[] args) {

        // Menu items
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("mocha");

        menu.add("latte");
        menu.add("capuccino");

        ArrayList<Item> items = new ArrayList<Item>();
        // Order variables -- order1, order2 etc.
        Item item1 = new Item();
        item1.name = "drip coffee";
        item1.price = 2.5;
        Order order1 = new Order();
        order1.name = "Cindhuri";
        order1.getOrderTotal(2.5);

        System.out.println(order1);

        Item item2 = new Item();
        item2.name = "mocha";
        item2.price = 5.5;
        Order order2 = new Order();
        order2.name = "Jimmy";
        items.add(item2);
        order2.getOrderTotal(5.0);
        order2.orderReady(true);


        Item item3 = new Item();
        item3.name = "capuccino";
        item3.price = 4.0;
        Order order3 = new Order();
        order3.name = "Noah";
        order3.getOrderTotal(4.5);

        items.add(item3);
    
        Item item4 = new Item();
        item4.name = "latte";
        item4.price = 4.25;
        Order order4 = new Order();
        order4.name = "Sam";
        items.add(item4);
        items.add(item4);
        items.add(item4);
        order4.getOrderTotal(12.5);

    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", item1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Your order is Ready: %s\n", order1.isReady);

        System.out.printf("Name: %s\n", item2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Your order is Ready: %s\n", order2.isReady);
    
        System.out.printf("Name: %s\n", item3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Your order is Ready: %s\n", order3.isReady);

        System.out.printf("Total: %s\n", order4.total);
            
    }
}
