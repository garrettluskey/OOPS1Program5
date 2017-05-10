
import java.text.DecimalFormat;
import java.util.*;

/**
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates and open the template
 in the editor.
 */
/**

 @author Mizuki Suzuki
 */
public class BankAccountManagement extends Throwable
{

   /**
    Compares the balance of this account to another account.
    Returns 0 if the balance of this account is larger, 1 if the balance
    of this account is smaller.
    @param acc the account to be compared to this object
    @return 0 if this account has the bigger balance, 1 if the 
    compared account has the bigger balance
    */
   private Scanner data;
   private ArrayList<Customer> customerList;
   private ArrayList<Account> accountList;

   /**
    Constructs a new object.
    */
   public BankAccountManagement()
   {
      data = new Scanner(System.in);
      customerList = new ArrayList<>();
      accountList = new ArrayList<>();
   }

   public void run()
   {
      String command = "c";

      System.out.println("Banking System is running...!");

      while (!command.equalsIgnoreCase("q"))
      {
         listChoices();
         command = data.next();

         switch (command)
         {
            case "c":
            case "C":
               createNewAccount();
               break;
            case "m":
            case "M":
               choseManageAccount();
               break;
            case "l":
            case "L":
               choseListAccounts();
               break;
            case "q":
            case "Q":
               System.out.println("Thanks for using Banking System. Bye!");
               break;
            default:
               System.out.println("Invalid command.");
         }
      }
   }

   /**
    Creates a new account.
    Creates a new account, either savings or checking based on user input,
    for a customer whose information is also entered by the user.
    */
   private void createNewAccount()
   {
      int accountType;
      int customerType = 0;

      System.out.println("Please enter the name of the customer: ");
      String name = data.next();
      String socialSecurityNumber = goodSSN(name);//Get customer SSN
      if (customerType == -1)
      {
         Customer newCustomer = new Customer(socialSecurityNumber, name);
         customerList.add(newCustomer);
      }
      accountType = accountType();
      switch (accountType)
      {
         case 1:
            createSavingsAccount(name); //Create new savings account
            break;
         case 2:
            createCheckingAccount(name); //Create new checking account
            break;
      }
   }
   
   /**
    Allows changes to be made to an existing account.
    Depending on the input, a user can deposit money in the account, withdraw
    money from the account, view the summary of the account or return to
    the run method.
    */
   private void manageAccount()
   {
      int command = -1;

      Account temp = accountList.get(findAccount());
      System.out.println("Please select account type: 1.View account "
            + "summary, 2.Withdraw, 3.Deposit, 4.Main menu");
      while (command == -1)
      {
         try
         {
            command = getValidCommand();
         }
         catch (Exception e)
         {
            System.out.println("Invalid Input. " + e.toString()
                  + " Please try again");
            data.next();
         }
      }
      switch (command)
      {
         case 1:
            System.out.println(temp.getAccountSummary());
            break;
         case 2:
            withdraw(temp);
            break;
         case 3:
            deposit(temp);
            break;
         case 4:
            break;
      }
   }
   
   /**
    Displays all accounts created after sorting them.
    Sorts all accounts by calling insertionSortInArrayList and displays 
    them in order, from the account with the smallest balance to the account 
    with the largest balance.
    */
   private void listAllAccounts()
   {
      Account temp;

      insertionSortInArrayList(accountList);
      try
      {
         for (int i = 0; i < accountList.size(); i++)
         {
            temp = accountList.get(i);
            System.out.println(temp.getAccountSummary());
         }
      }
      catch (IndexOutOfBoundsException e)
      {
         System.out.println("The total number of accounts is 0");
      }
   }
   
   /**
    Displays all possible commands in the run method.
    */
   private void listChoices()
   {
      System.out.println("Please enter C to create a new account, "
            + "M to manage an existing account, "
            + "L to list all account in the order by balance "
            + "from lowest to highest, Q to quit");
   }

   /**
    Creates a new savings account.
    Creates a new savings account by getting a valid account number via
    user input. The newly created account is added to the customer's account
    list and the list containing all accounts that have been created.
    @param name the name of the account holder
    */
   private void createSavingsAccount(String name)
   {
      System.out.println("Please enter account number "
            + "with five digits:");
      int accNumber = getValidAccountNumber();
      SavingsAccount newSavings = new SavingsAccount(name, accNumber);
      accountList.add(newSavings);
      customerList.get(findCustomer(name)).addAccount(newSavings);
      System.out.println("The new account has been created. "
            + "Account summary:\n" + newSavings.getAccountSummary());
   }

   /**
    Creates a new checking account.
    Creates a new checking account by getting a valid account number via
    user input. The newly created account is added to the customer's account
    list and the list containing all accounts that have been created.
    @param name the name of the account holder
    */
   private void createCheckingAccount(String name)
   {
      System.out.println("Please enter account number "
            + "with five digits:");
      int accNumber = getValidAccountNumber();
      CheckingAccount newChecking = new CheckingAccount(name, accNumber);
      accountList.add(newChecking);
      customerList.get(findCustomer(name)).addAccount(newChecking);
      System.out.println("The new account has been created. "
            + "Account summary:\n" + newChecking.getAccountSummary());
   }
   
   /**
    Determines what happens if the user chooses to manage an account.
    If the user tries to manage an account when there are no accounts, a
    message will be displayed and the user will return to the run method. If
    one or more accounts have been created, the method manageAccount will be
    called.
    */
   private void choseManageAccount()
   {
      if (accountList.size() > 0)
      {
         manageAccount();
      }
      else
      {
         System.out.println("The number of accounts is 0. "
               + "Please create an account first.");
      }
   }
   
   /**
    Withdraws a specified amount of money from an account.
    Gets user input on how much money they would like to withdraw and 
    attempts to withdraw that amount of money. If the amount is unable to be
    withdrawn, a message stating why will be displayed.
    @param acc the account money will be withdrawn from
    */
   private void withdraw(Account acc)
   {
      if (acc.isBalanceZero())
      {
         System.out.println("The balance is 0.0,"
               + " Please deposit before withdraw.");
      }
      else
      {
         System.out.println("Please enter the amount of money: ");
         float amount = getAmount(); //Get a float amount to withdraw
         if (acc.withdraw(amount))
         {
            String amountFormat = new DecimalFormat("0.##").format(amount);
            System.out.println("Your withdrawal has been accepted "
                  + "with an amount of " + amountFormat);
         }
      }
   }

   /**
    Deposits a specified amount of money into an account.
    Gets user input on how much money they would like to deposit and attempts 
    to deposit that amount of money. If the amount is unable to be deposited
    a message stating why will be displayed.
    @param acc the account money will be deposited into
    */
   private void deposit(Account acc)
   {
      System.out.println("Please enter the amount of money: ");
      float amount = getAmount(); //Get a float amount to deposit
      if (acc.deposit(amount))
      {
         String amountFormat = new DecimalFormat("0.##").format(amount);
         System.out.println("Your deposit has been received "
               + "with an amount of " + amountFormat);
      }
   }
   
   /**
    Gets a command for what to do when managing an account.
    Gets a command in the form of an integer between 1 and 4. If something
    other than an integer is entered, an exception is thrown. If and integer
    outside the inclusive range between 1 and 4 is entered, and error message
    is displayed.
    @throws Exception if the command is not an int
    @return a manage account command in the form of an integer
    */
   private int getValidCommand() throws Exception
   {
      int command = data.nextInt();
      if (command < 1 || command > 5)
      {
         if (command <= 10)
         {
            System.out.println("Invalid type. Please try again");
         }
         return -1;
      }
      return command;
   }
   
   /**
    Determines what occurs if the user chooses to list all created accounts.
    If no accounts have been created, a message stating so will be displayed 
    and the program will return to the run method. If one or more accounts
    have been created the method listAllAccounts will be called;
    */
   private void choseListAccounts()
   {
      if (accountList.size() > 0)
      {
         System.out.println("The total number of accounts is "
               + Account.totalNumberOfAccounts());
         listAllAccounts();
      }
      else
      {
         System.out.println("The total number of accounts is 0");
      }
   }
   
   /**
    Get and determines if the user input for they type of account they would 
    like to create is valid.
    Gets a valid number input from the user for the type of account they would
    like to create, which could be either savings or checking, and verifies 
    if it is a valid account type.
    @return an integer representing the type of account, 1 for savings and
    2 for checking
    */
   private int accountType()
   {
      int accountType = 0;

      System.out.println("Please select account type: "
            + "1.Savings, 2.Checking");
      while (accountType != 1 && accountType != 2)
      {
         accountType = getAcctType();
         if (accountType < 0 || accountType > 2)
         {
            System.out.println("Invalid type. Please try again");
         }
      }
      return accountType;
   }

   /**
    Gets user input for they type of account they would like to create.
    Creates a new savings account by getting a valid account number via
    user input. The newly created account is added to the customers account
    list and the list containing all accounts that have been created.
    @return an integer entered by the user indicating the account type they 
    would like to create
    */
   private int getAcctType()
   {
      int acctNumber = 0;

      try
      {
         acctNumber = data.nextInt();
         if (acctNumber == 0)
         {
            System.out.println("Invalid type. Please try again");
         }
      }
      catch (InputMismatchException e)
      {
         System.out.println("Invalid Input. " + e.toString()
               + " Please try again");
         data.next();
      }

      return acctNumber;
   }

   /**
    Determines if a user entered SSN is valid or not.
    Gets a social security number and tests it to determine if it is valid or
    not. Returns the social security number if it is valid, otherwise prints
    a message and gets another social security number.
    @param name the name of the account holder for the new account
    */
   private String goodSSN(String name)
   {
      boolean validSSN = false;
      String currentSSN = "Invalid";

      System.out.println("Please enter the SSN "
            + "of the customer (***-**-****):");
      while (!validSSN)
      {
         currentSSN = data.next();
         try
         {
            validSSN = hasProperFormat(currentSSN);
            if (validSSN)
            {
               validSSN = isAlreadyRegistered(currentSSN, name) != 2;
            }
         }
         catch (IllegalArgumentException e)
         {
            System.out.println("Invalid Social Security Number. "
                  + e.toString() + "\nPlease enter valid SSN:");
            validSSN = false;
         }
      }
      return currentSSN;
   }

   /**
    Determines if the social security number already belongs to a customer.
    Uses enteredName and enteredSSN to determine if the social security number
    is valid or not. If the social security number is in use and the name of 
    the person using the number is different from the entered name, then 
    @param enteredSSN the name of the account holder
    @param enteredName
    */
   private int isAlreadyRegistered(String enteredSSN, String enteredName)
   {
      Customer temp;
      int foundCustomer = 0; //Becomes 1 if a customer is found with same info
      int i = 0;

      while (i < customerList.size() - 1 && foundCustomer == 0)
      {
         temp = customerList.get(i);
         if (temp.isAlreadyCustomer(enteredSSN, enteredName))
         {
            foundCustomer = 1;
         }
         else if (temp.hasSameSSN(enteredSSN))
         {
            throw new IllegalArgumentException("Social Security Number "
                  + "belongs to another customer.");
         }
         i++;
      }
      if (foundCustomer == 0)
      {
         Customer newCustomer = new Customer(enteredSSN, enteredName);
         customerList.add(newCustomer);
      }
      return foundCustomer;
   }

   /**
    Checks if the given social security number is properly formatted.
    Checks a string to determine if it is formatted like a social security
    number. Returns true if it is formatted like a social security number and 
    throws an IllegalArgumentException if it is not formatted properly.
    @param enteredSSN the social security number to be tested
    @throw IllegalArgumentException if the string is not formatted properly
    */
   private boolean hasProperFormat(String enteredSSN)
         throws IllegalArgumentException
   {
      boolean validSSN = true;
      char currentChar;
      int i = 0;

      if (enteredSSN.length() != 11)
      {
         throw new IllegalArgumentException("The length of ssn "
               + "has to be 11.");
      }
      while (i < enteredSSN.length() && validSSN)
      {
         currentChar = enteredSSN.charAt(i);
         if (i != 3 && i != 6)//Check for int
         {
            validSSN = isDigit(currentChar);
         }
         else //Check for dash
         {
            validSSN = isDash(currentChar);
         }
         if (!validSSN)
         {
            throw new IllegalArgumentException("wrong format");
         }
         i++;
      }

      return validSSN;
   }

   /**
    Tests a character to determine if it is a digit.
    Determines if a character is a digit or not and returns true if it is a 
    digit, false if it is not.
    @param c the char to be tested
    @return true if the char is a digit, false if it is not
    */
   private boolean isDigit(char c)
   {
      return (c >= '0' && c <= '9');
   }

   /**
    Tests a character to determine if it is a dash.
    Determines if a character is a dash or not and returns true if it is a 
    dash, false if it is not.
    @param c the char to be tested
    @return true if the char is a dash, false if it is not
    */
   private boolean isDash(char c)
   {
      return (c == '-');
   }

   /**
    Gets a valid amount of money from user input.
    Uses user input to create a float value representing the money they would
    like to withdraw or deposit. 
    @return a float value entered by the user
    */
   private float getAmount()
   {
      boolean valid = false;
      float amount = 0;

      while (!valid)
      {
         try
         {
            amount = data.nextFloat();
            valid = true;
         }
         catch (InputMismatchException e)
         {
            System.out.println("Invalid Input. " + e.toString()
                  + " Please try again");
            data.next();
         }
      }

      return amount;
   }

   /**
    Finds an account if it exists.
    Searches the list of accounts which have been created to determine if the 
    account entered by the user exists. 
    @return i the index in the account list if the account exists
    */
   private int findAccount()
   {
      boolean foundAccount = false;
      int accNumber = 0;
      int i = 0;

      System.out.println("Please enter your account number:");
      accNumber = getValidAccountNumber();
      while (!foundAccount && i < accountList.size())
      {
         foundAccount = accountList.get(i).isAccount(accNumber);
         i++;
      }
      if (!foundAccount)
      {
         System.out.println("The account number you entered does not exist. "
               + "Please try again");
      }

      return i - 1;
   }

   /**
    Determines if a customer exists.
    Searches the list of customers for the customer having the name given 
    as a parameter.
    @param name the name of the account holder
    @return an integer equal to the index in the customer list where the
    customer is located if they exist, -1 if the customer does not exist
    */
   private int findCustomer(String name)
   {
      int customerNotFound = -1;
      for (int i = 0; i < customerList.size(); i++)
      {
         if (name.equals(customerList.get(i).getCustomerName()))
         {
            return i;
         }
      }
      return customerNotFound;
   }
   
   /**
    Returns a valid account number.
    Calls method newAccountNumber to get user input for an account number and 
    then tests to see if that number is valid. If the account number is valid
    then it is returned as an integer.
    @return an integer representing the account number of the account
    */
   private int getValidAccountNumber()
   {
      boolean validNum = false;
      int accNumber = 0;

      while (!validNum)
      {
         accNumber = newAccountNumber();
         validNum = (accNumber > 9999) && (accNumber < 100000);
         if (!validNum)
         {
            System.out.println("Invalid account number. Please try again");
         }
      }
      return accNumber;
   }
   
   /**
    Gets user input to create an account number.
    Uses user input to create an account number in the form of an integer. If 
    anything other than an integer is entered an exception is thrown and
    caught within the method.
    @return an integer representing an account number that has not been proven
    valid
    */
   private int newAccountNumber()
   {
      boolean validNum = false;
      int accNumber = 0;

      while (!validNum)
      {
         try
         {
            accNumber = getAccountNumber();
            validNum = true;
         }
         catch (Exception e)
         {
            System.out.println("Invalid Input. " + e.toString()
                  + " Please try again");
            data.next();
         }
      }

      return accNumber;
   }

   /**
    Gets an account number from user input.
    Gets an account number in the form of an integer via user input. If the 
    user enters anything other than a number, an exception is thrown.
    @return an integer representing the account number
    @throws an exception if anything other name a number is entered by the
    user
    */
   private int getAccountNumber() throws Exception
   {
      int accNumber;
      accNumber = data.nextInt();
      return accNumber;
   }
   
   /**
    Sorts the list containing all accounts.
    Sorts the list containing all accounts created by each accounts balance,
    from smallest to largest.
    @param accList the account list containing all accounts created
    */
   private void insertionSortInArrayList(ArrayList<Account> accList)
   {
      int j;
      for (int i = 1; i < accountList.size(); i++)
      {
         j = i;
         while (j > 0
               && accountList.get(i).compareTo(accountList.get(j - 1)) == 1)
         {
            j--;
         }
         accountList.add(j, accountList.remove(i));
      }
   }
}
