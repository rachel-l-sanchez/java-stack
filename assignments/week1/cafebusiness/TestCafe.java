import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil getCafe = new CafeUtil();

        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", getCafe.getStreakGoal());
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",getCafe.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();        
        getCafe.displayMenu(menu);
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            getCafe.addCustomer(customers);
            System.out.println("\n");
        }
        getCafe.printPriceChart("drip coffee", 2.5, 3, menu);
    }
}
