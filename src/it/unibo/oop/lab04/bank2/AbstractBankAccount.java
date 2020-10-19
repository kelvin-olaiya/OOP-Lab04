package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

public abstract class AbstractBankAccount implements BankAccount {
	private static final double ATM_TRANSACTION_FEE = 1;
	
	private double balance;
	private int nTrasactions;
	private int userID;
	
	public AbstractBankAccount(int usrID, double amount) {
		this.balance = amount;
		this.nTrasactions = 0;
		this.userID = usrID;
	}
	
	public void computeManagementFees(int usrID) {
		double feeAmount = this.computeFee();
		if (this.checkUser(usrID) && this.isWithDrawAllowed(feeAmount)) {
			this.balanceOperation(-feeAmount);
			this.resetNTransaction();
		}
	}

	public void deposit(int usrID, double amount) {
		if (this.checkUser(usrID)) {
			this.balanceOperation(amount);
		}
    }

    public void depositFromATM(int usrID, double amount) {
    	if (this.checkUser(usrID)) {
    		this.balanceOperation(amount - ATM_TRANSACTION_FEE);
    	}
    }

    public double getBalance() {
    	return this.balance;
    }

    public int getNTransactions() {
    	return this.nTrasactions;
    }

    public void withdraw(int usrID, double amount) {
    	if(this.checkUser(usrID) && this.isWithDrawAllowed(amount)) {
    		this.balanceOperation(-amount);
    	}
    }

    public void withdrawFromATM(int usrID, double amount) {
    	if(this.checkUser(usrID) && this.isWithDrawAllowed(amount)) {
    		this.balanceOperation(-(amount + ATM_TRANSACTION_FEE));
    	}
    }

	private boolean checkUser(int usrID) {
		return this.userID == usrID;
	}
    
    private void balanceOperation(double amount) {
    	this.incNTransaction();
    	this.balance += amount;
    }
    
    private void resetNTransaction() {
		this.nTrasactions = 0;
	}
    
    protected void incNTransaction() {
    	this.nTrasactions++;
    }
    
    protected abstract boolean isWithDrawAllowed(double amount);
    
    protected abstract double computeFee();

}
