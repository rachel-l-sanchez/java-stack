import java.util.*;
import java.util.Random;

public class BankAccount {
	private double checkingBalance;
	private double savingsBalance;
	private static int accounts;
	private static double allAccountBalance;
	private static String accountNumber;
	
	public BankAccount(double cBalance,double sBalance, int length){
		checkingBalance = cBalance;
		savingsBalance = sBalance;
		accountNumber = accountNum(length);
		accounts++;	
		allAccountBalance = checkingBalance + savingsBalance;
	}
	
	public static int numAccounts() {
		return accounts;
	}
	
	public static double allAccBalance() {
		return allAccountBalance;
	}
	
	public double checkingAccBalance() {
		return checkingBalance;
	}
	
	public double savingBalance() {
		return savingsBalance;
	}
	
	public double addToBalance(double cBalance, double sBalance, double depositing) {
		if (depositing > 0 && checkingBalance == cBalance) {
			checkingBalance = checkingBalance + depositing;	
			return checkingBalance;
		}
		if (depositing > 0 && savingsBalance == sBalance) {
			savingsBalance = savingsBalance + depositing;
			return savingsBalance;
		}
		return depositing;
	}
	
	private String accountNum(int length) {
		Random random = new Random();
		length = 10;
		for (int i=0; i<length; i++) {
            int randomInt = random.nextInt(1000000000);
            String savedNumber = "" + randomInt;
            accountNumber = savedNumber;
		}
        return accountNumber;

	}

	public int finalAccountNumber() {
		int finalNumber = Integer.parseInt(accountNum(10));
		System.out.println(finalNumber);
		return finalNumber;
	}
	
	public void withdraw(double checkingBalance, double savingBalance, double withdrawAmt) {
		if (checkingBalance == checkingBalance && checkingBalance > withdrawAmt) {
			checkingBalance = checkingBalance - withdrawAmt;
		}
		if (savingsBalance == savingBalance && savingsBalance > withdrawAmt) {
			savingsBalance = savingsBalance - withdrawAmt;
			System.out.println("This is the savings balance" + savingsBalance);
		}
		else {
			System.out.println(withdrawAmt + " is too large for the account balance");
		}
	}
	
}
