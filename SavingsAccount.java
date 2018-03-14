/** This class works as a part of the BankAccount class.
* The SavingsAccount allows for accumulation of interest
* to occur.
* This version is made by Dayan Jayasuriya, Nicki Lindstrom,
* and Riley Schaaf.
*/

public class SavingsAccount extends BankAccount {

  private double annualInterestRate;
  public static final double MONTHLY_FEE = 5.0;
  public static final double MINIMUM_BALANCE = 1000.0;
  public static final double MONTHS = 12;

  /**
  * Default constructor
  */
  public SavingsAccount(){};

  /**
  * Constructs a new saving account. Requires an account holder of the Customer
  class, starting balance, and an annual interest rate to be passed to it to use.
  */
  public SavingsAccount(Customer accountHolder, double startBalance, double annualInterestRate){
    super(accountHolder, startBalance);
    setAnnualInterestRate(annualInterestRate);
  }

  /**
  * Method that gets the annual interest rate for the account.
  */
  public double getAnnualInterestRate(){
    return annualInterestRate;
  }

  /**
  * Method that sets the annual interest rate for the account.
  */
  public void setAnnualInterestRate(double rate){
    annualInterestRate = rate / 100;
  }

  /**
  * Calculates the monthly bank fees and interest and returns it as a value.
  */
  protected double getMonthlyFeesAndInterest(){
    double monthlyFeesAndInterest = 0.0;
    if (getBalance() < MINIMUM_BALANCE){
      monthlyFeesAndInterest = getBalance() * (annualInterestRate/MONTHS) - MONTHLY_FEE;
    }else{
      monthlyFeesAndInterest = getBalance()  * (annualInterestRate/MONTHS);
    }
    return monthlyFeesAndInterest;
  }

}
