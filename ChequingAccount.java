/** This class works as a part of the BankAccount class.
* The ChequingAccount allows for overDrafts to occur and charges a
* fee for them.
* This version is made by Dayan Jayasuriya, Nicki Lindstrom,
* and Riley Schaaf.
*/
public class ChequingAccount extends BankAccount {
  private double overdraftfee;
  private double overdraftAmount;
  private final double MINIMUM_BALANCE = 0.0;
  private final double PENALTY_RATE = 0.2;

  /**
  * Constructor that sets overdraft fee.
  */
  public ChequingAccount(double transactionFee) {
    setOverdraftfee(transactionFee);
  }

  /**
  * Constructor that sets an account holder, starting chequing account balance,
  * and overdraft fee.
  */
  public ChequingAccount(Customer accountHolder, double startBalance,
                          double transactionFee) {
    super(accountHolder, startBalance);
    this.setOverdraftfee(transactionFee);
  }

  /**
  * Getter methods for overdraft fee and threshold for overdraft to kick in.
  */
  public double getOverdraftFee() {
    return overdraftfee;
  }
  public double getOverdraftAmount() {
    return overdraftAmount;
  }

  /**
  * Setter Methods for overdraft fee and threshold for overdraft to kick in.
  */
  public void setOverdraftfee(double fee) {
    overdraftfee = fee;
  }
  public void setOverdraftAmount(double amount) {
    overdraftAmount = -amount;
  }

  /**
  * Withdraw method that overrides the withdraw method in BankAccount
  * Allows for negative withdrawls
  */
  public void withdraw(double amount) {

    double currentBalance = getBalance();
    //if after withdrawl the balance is above 0, go ahead and withdraw the money
    if ((currentBalance - amount) >= 0.0) {
        setBalance(currentBalance - amount);
      }
    /* if after withdrawl the balance is below 0, check the balance does not violate
    the overdraft amount. If it does not, allow the withdrawl and impose the
    fee*/
    else if ((currentBalance - amount) >= getOverdraftAmount()){
        setBalance(currentBalance - (amount + getOverdraftFee()));
      }
  }

  /**
  * Gets the monthly bank fees and interest
  */
  protected double getMonthlyFeesAndInterest(){
    double monthlyFeesAndInterest = 0.0;
    if (getBalance() < MINIMUM_BALANCE){
      monthlyFeesAndInterest = getBalance() * PENALTY_RATE;
    }
    return monthlyFeesAndInterest;
  }
}
