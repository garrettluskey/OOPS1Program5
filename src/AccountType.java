/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**

 @author Mizuki Suzuki
 */
public enum AccountType
{
   SavingsAccount(1, "savings"),
   CheckingAccount(2, "checking"),
   InvalidType(3, "Invalid type");

   private final int type;
   private final String name;

   /**
    Constructs a new object.
    @param type is an integer denoting the type of account
    @param name is the name of the type of account
    */
   AccountType(int type, String name)
   {
      this.type = type;
      this.name = name;
   }

   /**
    Returns the name of the account.
    @return the string variable name
    */
   String accNameIs()
   {
      return name;
   }

}
