import java.util.ArrayList;
import java.util.Scanner;
import java.text.*;

public class CafeUtil {
    public int getStreakGoal() {
        int drinkPrev = 0;
        int numWeeks = 11;
        boolean isUserAdmin = false;
        if (isUserAdmin == true) {
            Scanner weekObject = new Scanner(System.in);
            System.out.println("Enter number of weeks customer has bought a drink");
            int weeksVisited = weekObject.nextInt();
            numWeeks = weeksVisited;
            weekObject.close();
        }
        for (int i=1; i<numWeeks; i++) {
            drinkPrev = (drinkPrev + i);
        }
        int drinkSum = drinkPrev;
        return drinkSum;
    }

    double[] priceArr = new double[4];
    double sum = 0;
    public double getOrderTotal(double[] prices) {
        for (int i=0; i<prices.length; i++) {
            double values = prices[i];
            System.out.println(values);
            sum = sum + values; 
        }
        return sum;
    }

    public void displayMenu (ArrayList<String> menu) {
        menu.add("drip coffee");
        menu.add("capuccino");
        menu.add("latte");
        menu.add("mocha");
        System.out.println("1 : " +menu.get(0));
        System.out.println("2 : "+ menu.get(1));
        System.out.println("3 : " + menu.get(2));
        System.out.println("4 : "+menu.get(3));
    }
      

    public void addCustomer (ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        userName.close();
        System.out.println("Hello " + userName);
        customers.add(userName);
        System.out.println("There are " + (customers.size()) +"people in front of you");
    }

    public void printPriceChart(String product, double price, int maxQuantity, ArrayList<String> menu) {
        String productItem = product;
        if (productItem =="capuccino") {
            product = menu.get(1);

        }
         if (productItem == "mocha") {
            product = menu.get(3);

        }
        if (productItem == "drip coffee") {
            product = menu.get(0);

        }
        if (productItem == "latte") {
            product = menu.get(2);
          

        }
        price = price * maxQuantity;
        System.out.println(maxQuantity + " - " +price);
    }
}
    



