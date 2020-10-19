package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount{
	private static final double TRANSACTION_FEE = 0.1;
	private static final double MANAGEMENT_FEE = 5;
	
	public RestrictedBankAccount(int usrID, double amount) {
		super(usrID, amount);
	}

	protected boolean isWithDrawAllowed(double amount) {
		return getBalance() > amount;
	}

	protected double computeFee() {
		return MANAGEMENT_FEE + getNTransactions() * TRANSACTION_FEE;
	}

}
