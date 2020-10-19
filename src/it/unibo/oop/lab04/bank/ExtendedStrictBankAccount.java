package it.unibo.oop.lab04.bank;

public class ExtendedStrictBankAccount extends SimpleBankAccount {
	private static final double TRANSACTION_FEE = 0.1;

	public ExtendedStrictBankAccount(int usrID, double balance) {
		super(usrID, balance);
	}
	
	private boolean isWithdrawAllowed(final double amount) {
        return getBalance() > amount;
    }
	
	public void computeManagementFees(final int usrID) {
        final double feeAmount = MANAGEMENT_FEE + (getNTransactions() * TRANSACTION_FEE);
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
            setBalance(getBalance() -feeAmount);
            resetTransactions();
        }
    }

	public static double getTransactionFee() {
		return TRANSACTION_FEE;
	}

}
