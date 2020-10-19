package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount {

	public ClassicBankAccount(int usrID, double amount) {
		super(usrID, amount);
	}

	protected boolean isWithDrawAllowed(double amount) {
		return true;
	}

	protected double computeFee() {
		return 0;
	}

}
