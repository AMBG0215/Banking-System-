import java.util.ArrayList;

public class BankSystem {

    private static ArrayList<BankAccount> accounts = new ArrayList<>();

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


    // Since the arraylist is private, create a method to access the accounts in the main. Since you added the account, output each. 
    static BankAccount showAccounts() {
        for (BankAccount listAccounts : accounts) {
            System.out.println(listAccounts.getName() + " - " + listAccounts.getBalance());

        }
    }




}
