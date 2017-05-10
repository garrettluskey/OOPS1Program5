
import java.text.DecimalFormat;

/**
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates and open the template
 in the editor.
 */
/**

 @author Mizuki Suzuki
 */
public class CheckingAccount extends Account
{

   /**
    Constructs a new object.
    @param name the name of the account holder
    @param number the account number
    */
   public CheckingAccount(String name, int number)
   {
      accountHolderName = name;
      accountNumber = number;
      accountType = AccountType.CheckingAccount;
      balance = 0.00f;
      totalAccountNumber++;
   }

   /**
    Returns the balance of the account.
    @return the float variable balance
    */
   @Override
   public float getAccountBalance()
   {
      return balance;
   }

   /**
    Returns a detailed summary of the account in the form of a string.
    Overridden method that returns the parent class version and adds the 
    formatted balance with some text to the end of the string. Unformatted
    balance is found by calling the method getAccountBalance.
    @return a string containing text and variables containing the name of the
    account holder, the account number, the account type and the balance
    */
   @Override
   public String getAccountSummary()
   {
      String balanceF = new DecimalFormat("0.##").format(getAccountBalance());
      return (super.getAccountSummary()
            + "; Account balance is " + balanceF);
   }
}
