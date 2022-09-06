public class BankTest {
	public static void main(String[] args) {
		BankAccount appTest = new BankAccount(100.5,10000.15, 10);
		System.out.println("\n" + "This is the numAccounts test");
		System.out.println(BankAccount.numAccounts());
		
		System.out.println("\n" +"This is the account balance test");
		System.out.println(BankAccount.allAccBalance());
		
		
		System.out.println("\n" + "This is the checkingAccBalance test");
		System.out.print(appTest.checkingAccBalance());	

		
		System.out.println("\n" + "This is the savingBalance test");
		System.out.print(appTest.savingBalance());	

		
		System.out.println("\n" + "This is the addToBalance test");
		System.out.print(appTest.addToBalance(0,200, 100));	


		System.out.println("\n" + "This is the withdraw test");
		appTest.withdraw(50, 0, 100);	
		
		System.out.println("\n" + "This is the accountNumber test");
		System.out.println(appTest.finalAccountNumber());
		

	}
}
