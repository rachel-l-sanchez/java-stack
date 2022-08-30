public class CafeJava {
        public static void main(String[] args) {
            Greeting getGreeting = new Greeting();
            Price currentPrice = new Price();
            Customer currentCustomer = new Customer();
            boolean isReadyOrder1 = false;
            boolean isReadyOrder2 = true;

            if (isReadyOrder2) {
                    if (currentCustomer.firstCustomer() == "Cindhuri" ) {
                        System.out.println(getGreeting.getGreeting() + currentCustomer.firstCustomer());
                        System.out.println(currentCustomer.firstCustomer() +getGreeting.pendingOrder());
                        System.out.println(currentCustomer.firstCustomer() +getGreeting.readyOrder());
                        System.out.println(getGreeting.totalPrice() +currentPrice.dripCoffee());
                    }
                    if (currentCustomer.secondCustomer() == "Noah") {
                        System.out.println(getGreeting.getGreeting() + currentCustomer.secondCustomer());
                        System.out.println(currentCustomer.secondCustomer() +getGreeting.pendingOrder());
                        System.out.println(currentCustomer.secondCustomer() +getGreeting.readyOrder());
                        System.out.println(getGreeting.totalPrice() +currentPrice.capuccino());
                    }
                    if (currentCustomer.thirdCustomer() == "Jimmy") {
                        System.out.println(getGreeting.getGreeting() + currentCustomer.thirdCustomer());
                        System.out.println(currentCustomer.thirdCustomer() +getGreeting.pendingOrder());
                        System.out.println(currentCustomer.thirdCustomer() +getGreeting.readyOrder());
                        System.out.println(getGreeting.totalPrice() +currentPrice.dripCoffee());
                        double newPrice = currentPrice.latte() - currentPrice.dripCoffee();
                        System.out.println(getGreeting.totalPrice() + newPrice);
                    }
                    if (currentCustomer.fourthCustomer() == "Sam") {
                        System.out.println(currentCustomer.fourthCustomer() +getGreeting.readyOrder());
                        double priceOfTwo = currentPrice.latte() * 2;
                        System.out.println(getGreeting.totalPrice() + priceOfTwo);
                    }
            } 
            if (isReadyOrder1) {
                    System.out.println(getGreeting.getGreeting());
                    System.out.println(currentCustomer.fourthCustomer() +getGreeting.pendingOrder());
                }
        }
            

    }
    
