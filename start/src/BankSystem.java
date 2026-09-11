import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;


// BankSystem uses BankAccount
// Association ("USES-A" / "KNOWS"):
// One class uses or knows about another class.
// It can receive a reference to another object or interact with it,
// but it does not necessarily own that object.
// The two objects can exist independently.

// BankSystem has a bank account
// Aggregation ("HAS-A" WEAK):
// One class contains or uses another object, but both objects
// can exist independently.
// If the parent is destroyed, the child can still exist.
// Example: A BankSystem has BankAccount objects.
// The BankAccount can exist independently of the BankSystem.

// Manages many bank accounts
public class BankSystem {


    // Arraylist stores Bank Account objects so, accounts = []
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static ArrayList<Transaction> transacts = new ArrayList<>();

    static void addAccount(BankAccount account){
        accounts.add(account);
    }

    static void addTransaction(Transaction transaction){
        transacts.add(transaction);
    }

    static void showTransactions(){
        for (Transaction transactList : transacts){
            System.out.println("Transaction History: " + "\n" +
                    transactList.getTransactionId()+ "\n" +
                    transactList.getTransactionType() + "\n" +
                    transactList.getAmount() + "\n" +
                    transactList.getDate() + "\n" +
                    transactList.getAccount().getBalance()
            );
        }
    }

    static BankAccount findAccounts(String accountNumber){
        for (BankAccount account : accounts){
             if (account.getNumber().equals(accountNumber)){
                 return account;
             }
        }
            return null;
    }

    // Think of a way to remove the account by using the accountNumber
    static void removeAccount(String accountNumber){
        BankAccount result = BankSystem.findAccounts(accountNumber);

        if (result != null){
            accounts.remove(result);
            System.out.println("Account is removed");
        }else{
            System.out.println("Account not found");
        }

    }
    
    static void updateName(String accountNumber, String name){
        boolean found = false;

        for (BankAccount listAccounts : accounts){
            if (listAccounts.getNumber().equals(accountNumber)) {
                listAccounts.setName(name);
                found = true;
            }
        }

        if (!found){
            System.out.println("No existing account");
        }

    }

    // create a method to show only one account
    static void displayAccount(String accountNumber){
        BankAccount result = BankSystem.findAccounts(accountNumber);

        if (result != null){
            System.out.println(
                         "This is your account: " +
                            result.getNumber() + " " +
                            result.getName() + " " +
                            result.getBalance()
            );
            result.showAccountType();

        }else{
            System.out.println("Account not found");
        }

    }


    // Since the arraylist is private, create a method to access the accounts in the main. Since you added the account, output each. 
    static void showAccounts() {
        for (BankAccount listAccounts : accounts) {
            System.out.println(
                    "Account Number: " + listAccounts.getNumber() + "\n" +
                    "Name: " + listAccounts.getName() + "\n" +
                    "Balance: " + listAccounts.getBalance() + "\n" +
                    "Active: " + listAccounts.isActive()
                    );

            listAccounts.showAccountType();

        }
    }

    static void findAccountsByName(String name){
        boolean found = false;

        for (BankAccount listAccounts : accounts){
           if(listAccounts.getName().toLowerCase().contains(name.toLowerCase())){
               System.out.println(
                   "Account Number: " + listAccounts.getNumber() + "\n" +
                   "Name: " + listAccounts.getName() + "\n" +
                   "Balance: " + listAccounts.getBalance() + "\n" +
                   "Active: " + listAccounts.isActive()
               );
               found = true;
           }
        }
        if(!found){
            System.out.println("Name is not found");
        }
    }

    // fix the logic for activate account
    static void activateAccount(String accountNumber){
            BankAccount result = BankSystem.findAccounts(accountNumber);
            boolean found = false;

            if(result != null){
                for (BankAccount listAccounts : accounts){
                    if (listAccounts.getNumber().equals(accountNumber)){
                        if(listAccounts.isActive()){
                            System.out.println("Account already active");
                        }else{
                            System.out.println("Account activated");
                            listAccounts.setActive(true);
                        }
                    }
                    found = true;
                }
                if(!found){
                    System.out.println("Account is already activated.");
                }
            }else{
                System.out.println("No Account found.");
            }

    }

    static void deactivateAccount(String accountNumber){
        BankAccount result = BankSystem.findAccounts(accountNumber);
        boolean found = false;

        if(result != null){
            for (BankAccount listAccounts : accounts){
                if (listAccounts.getNumber().equals(accountNumber)){
                    if(listAccounts.isActive()){
                        System.out.println("Account deactivated");
                        listAccounts.setActive(false);
                    }else{
                        System.out.println("Account is already deactivated");
                    }
                }
                found = true;
            }
            if(!found){
                System.out.println("Account is already deactivated.");
            }
        }else{
            System.out.println("No Account found.");
        }
    }


    static void showAccountType(){
        for (BankAccount listAccounts : accounts) {
            System.out.println(
                    "Account Number: " + listAccounts.getNumber() + "\n" +
                            "Name: " + listAccounts.getName() + "\n" +
                            "Balance: " + listAccounts.getBalance() + "\n" +
                            "Active: " + listAccounts.isActive()
            );

            // Savings Account is a type of Bank Account so, BankAccount account = new SavingsAccount(...);
            // This asks user's account object: "Show me your account type." So if new BankAccount() -> Regular; new SavingsAcc() -> Savings

            listAccounts.showAccountType();

            // Reference type: BankAccount

            // Actual object: SavingsAccount if new SavingsAcc()
            // Then when you add it to the list: BankSystem.addAccount(account1); the actual SavingsAccount object is stored in accounts.
            // Later: for (BankAccount listAccounts : accounts) Java gets the same object from the list.
            // so when this runs: listAccounts.showAccountType();
            // is this object a savings acc? yes

        }
    }

    static int counter = 0;
    static void depositToAccount(String accountNumber, int amount){


        BankAccount result = BankSystem.findAccounts(accountNumber);

        if (result != null){
//             System.out.println("Account found, " + amount + " deposited");
             result.deposit(amount);

                    // improve logic for transaction 
                    Transaction depositTransact = new Transaction("T00" + ++counter, "DEPOSIT", amount, "2026-09-11", result);
                        addTransaction(depositTransact);

        }else{
            System.out.println("Account not found");
        }

    }

    // Fix the transaction History logic
    static void transactionHistory(Transaction transact){
            transacts.add(transact);
    }

    static void withdrawFromAccount(String accountNumber, int amount){
        BankAccount result = BankSystem.findAccounts(accountNumber);

        if (result!= null){
//           System.out.println("Account found, " + amount + " withdraw");
            result.withdraw(amount);
        }else{
            System.out.println("Account not found");
        }
    }

    static void transfer(String accountNumber1, String accountNumber2, int amount){
        BankAccount result1 = BankSystem.findAccounts(accountNumber1);
        BankAccount result2 = BankSystem.findAccounts(accountNumber2);

        if(result1 != null && result2 != null){
            result1.transfer(result2, amount);

        }else{
            System.out.println("Account not found");
        }

    }



}
