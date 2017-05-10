import java.io.*;
import java.util.*;

/**
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates and open the template
 in the editor.
 */

/**

 @author Mizuki Suzuki
 */
public class Customer
{

   private final String socialSecurityNumber;
   private final String name;
   private ArrayList<Account> accountList;

   /**
    Creates a new object.
    @param ssn the social security number of the account holder
    @param enteredName the name of the account holder
    */
   public Customer(String ssn, String enteredName)
   {
      socialSecurityNumber = ssn;
      name = enteredName;
      accountList = new ArrayList<>();
   }

   /**
    Tests to see if the input matches the account holders information.
    Tests to see if givenSSN matches the social security number of the user
    and givenName matches the name of the account holder.
    @param givenSSN the given social security number
    @param givenName the given name
    @return true if givenSSN matches the social security number and givenName 
    matches the name of the account holder
    */
   public boolean isAlreadyCustomer(String givenSSN, String givenName)
   {
      boolean isValid = this.socialSecurityNumber.equals(givenSSN)
            && this.name.equals(givenName);
      return isValid;
   }

   /**
    Tests to see if the given social security number account holders number.
    Tests to see if enteredSSN matches the social security number of the user
    and givenName matches the name of the account holder.
    @param enteredSSN the given social security number
    @return true if enteredSSN matches the social security number of the 
    account holder
    */
   public boolean hasSameSSN(String enteredSSN)
   {
      return this.socialSecurityNumber.equals(enteredSSN);
   }

   /**
    Returns the customers social security number.
    @return true if givenSSN matches the social security number and givenName 
    matches the name of the account holder
    */
   public ArrayList<Account> getAccountList()
   {
      return accountList;
   }

   /**
    Adds the given account to the customers account list.
    @param acc the account to be added to the customers account list
    */
   public void addAccount(Account acc)
   {
      accountList.add(acc);
   }

   /**
    Returns the customers name.
    @return a string variable storing the customers name.
    */
   public String getCustomerName()
   {
      return name;
   }
}
