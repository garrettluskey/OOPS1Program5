
import java.text.*;

/**
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates and open the template
 in the editor.
 */
/**

 @author Mizuki Suzuki
 */
public abstract class Account extends Throwable implements Comparable<Account>
{

   public int accountNumber;
   public String accountHolderName;
   public float balance;
   public AccountType accountType;
   public static int totalAccountNumber = 0;

   /**
    Withdraws the specified amount from the balance of the account.
    Prints out an error message if the amount entered is not positive and
    greater than zero or is greater than the balance of the account.
    @param amount to be withdrawn from the account
    @return  true if the withdrawal was successful, false if it was not
    */
   public boolean withdraw(float amount)
   {
      if (!amountGreaterThanZero(amount))
      {
         System.out.println("Amount must be positive "
               + "and greater than zero.");
         return false;
      }
      getAccountBalance();
      float newBalance = balance - amount;
      if (newBalance >= 0)
      {
         balance = newBalance;
         return true;
      }
      else
      {
         System.out.println("You don't have enough balance."
               + " Please try a different amount.");
         return false;
      }
   }

   /**
    Deposits the specified amount by adding it to the balance of the account.
    Prints out an error message if the amount entered is not positive and
    greater than zero.
    @param amount to be deposited in the account
    @return  true if the deposit was successful, false if it was not
    */
   public boolean deposit(float amount)
   {
      if (!amountGreaterThanZero(amount))
      {
         return false;
      }
      balance += amount;
      return true;
   }

   /**
    Abstract method to be used in SavingsAccount and CheckingAccount classes.
    */
   abstract float getAccountBalance();

   /**
    Compares the balance of this account to another account.
    Returns 0 if the balance of this account is larger, 1 if the balance
    of this account is smaller.
    @param acc the account to be compared to this object
    @return 0 if this account has the bigger balance, 1 if the 
    compared account has the bigger balance
    */
   @Override
   public int compareTo(Account acc)
   {
      if (this.balance - acc.balance > 0)
      {
         return 0;
      }
      else
      {
         return 1;
      }
   }

   /**
    Returns a detailed summary of the account in the form of a string.
    @return a string containing text and variables containing the name of the
    account holder, the account number, and the account type
    */
   public String getAccountSummary()
   {
      return ("Account holder is " + accountHolderName
            + "; Account number is " + accountNumber
            + "; Account type is " + accTypeIs());
   }

   /**
    Compares the account number of this account with another account number.
    Returns a true or false depending on whether or not this account
    has and account number equal to accountNumber.
    @param accountNumber the number of the account being searched for
    @return true if this account number is the same as accountNumber, false 
    if not
    */
   public boolean isAccount(int accountNumber)
   {
      return this.accountNumber == accountNumber;
   }

   /**
    Returns the account number of this account.
    @return the integer accountNumber
    */
   public int returnAccountNumber()
   {
      return accountNumber;
   }

   /**
    Determines if the balance of the account is zero.
    Returns true or false depending on whether the balance of the account
    is zero or not.
    @return true if balance is zero, false if it is not
    */
   public boolean isBalanceZero()
   {
      return balance == 0;
   }

   /**
    Returns new balance of the account after withdrawal or deposit with text.
    @return returns text and the integer balance in a string
    */
   public String newBalance()
   {
      return ("Your new balance is: " + balance);
   }

   /**
    Returns the account type as a string.
    @return a string containing the account type
    */
   public String accTypeIs()
   {
      return accountType.accNameIs();
   }

   /**
    Determines if the balance of the account is zero.
    Returns true or false depending on whether the amount is greater than zero
    or not.
    @param amount a float to be tested
    @return true if the amount is greater than zero, false if it is not
    */
   private boolean amountGreaterThanZero(float amount)
   {
      return amount > 0;
   }

   /**
    Displays account information.
    */
   public void displayAccountInfo()
   {
      String balanceString = new DecimalFormat("0.##").format(balance);
      System.out.print("Account holder is " + accountHolderName
            + "; Account number is " + accountNumber
            + "; Account type is " + accountType.accNameIs()
            + "; Account balance is " + balanceString);
   }

   /**
    Returns the total number of accounts created.
    @return the total number of accounts in the form of an integer
    */
   public static int totalNumberOfAccounts()
   {
      return totalAccountNumber;
   }

}
