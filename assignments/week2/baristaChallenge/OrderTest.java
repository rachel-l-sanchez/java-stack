import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class OrderTest {
    public static void main(String[] args) {

        // Menu items
        ArrayList<Item> menu = new ArrayList<Item>();

        // instantiation of order and item variables
        Item item1 = new Item("drip coffee", 2.5);
        String dripCoffee = item1.getName("drip coffee");
        Order order1 = new Order();
        Order order1Name = new Order("Cindhuri", dripCoffee);

        Item item2 = new Item("mocha", 5.5);
        String mocha = item2.getName("mocha");
        Order order2 = new Order();
        Order order2Name = new Order("Noah", mocha);

        Item item3 = new Item("capuccino", 4.5);
        String capuccino = item3.getName("capuccino");
        Order order3 = new Order();
        Order order3Name = new Order("Jimmy", capuccino);

        Item item4 = new Item("latte", 4.25);
        String latte = item4.getName("latte");

        Order order4 = new Order();
        Order order4Name = new Order("Sam", latte);

        ArrayList<Item> items = new ArrayList<Item>(Arrays.asList(item1, item2, item3, item4));

        menu.add(item1);
        menu.add(item4);
        menu.add(item3);
        menu.add(item2);

        // add to ArrayList
        order1.addItem(item1, items);
        order2.addItem(item4, items);
        order3.addItem(item3, items);
        order4.addItem(item2, items);

        // display order
        System.out.println(order1Name.display(menu, 1, 2.5, "Cindhuri", "drip coffee", items));
        System.out.println(order2Name.display(menu, 1, 5.5, "Noah", "mocha", items));
        System.out.println(order3Name.display(menu, 1, 4.0, "Jimmy", "capuccino", items));
        System.out.println(order4Name.display(menu, 3, 4.25, "Sam", "latte", items));
        
        // Application Simulations
        order1.getOrderTotal(2.5, 1, menu.get(0), items);
        order4.getOrderTotal(12.5, 3, menu.get(3), items);
        order3.getOrderTotal(4.5, 1, menu.get(2), items);
        order2.getOrderTotal(5.0, 1, menu.get(1), items);
       
        order2.orderReady(true);
        System.out.println("Noah:" + order2.getStatusMessage());
    




    }
}
