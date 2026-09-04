import java.util.ArrayList;

// Manages many bank accounts
public class BankSystem {

    // Arraylist stores Bank Account objects so, accounts = []
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    // Composition: one class has or uses objects from another class.

    static void addAccount(BankAccount account){
          accounts.add(account);
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


    static void depositToAccount(String accountNumber, int amount){
        BankAccount result = BankSystem.findAccounts(accountNumber);

        if (result != null){
             System.out.println("Account found, " + amount + " deposited");
             result.deposit(amount);
        }else{
            System.out.println("Account not found");
        }

    }

    static void withdrawFromAccount(String accountNumber, int amount){
        BankAccount result = BankSystem.findAccounts(accountNumber);

        if (result!= null){
            System.out.println("Account found, " + amount + " withdraw");
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
