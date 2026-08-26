//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//
//        BankAccount account1 = new BankAccount("0101", "Mika", 500, true);
//        BankAccount account2 = new BankAccount("0102", "Anna", 400, false);

        // Arraylist: a container that can hold multiple things.
//        ArrayList<String> names = new ArrayList<>();
//        names.add("Mika");
//        names.add("Anna");
//        System.out.println(names);

//        ArrayList<BankAccount> accounts = new ArrayList<>();
//        accounts.add(account1);
//        accounts.add(account2);
//        accounts.get(0).deposit(500);
//        System.out.println(accounts.get(0).getBalance());
//        accounts.get(1).withdraw(100);
//        System.out.println(accounts.get(1).getBalance());

        // For every BankAccount inside accounts, temporarily call it account and do something with it.
//
//        for (BankAccount account: accounts){
//            //.equals is used because == is used to compare primitive values, string is NOT primitive.
//            if (account.getNumber().equals("0102")) {
//                System.out.println("Account found: " + account.getName() + " - " + account.getBalance());
//            }
//        }
//

//        account.deposit(5000);
//        System.out.println(account.getName());
//        account.setName("John");
//        System.out.println(account.getName());

//        account.deposit(200);
//
//        account1.introduce();
//        account2.introduce();
//
//        account1.transfer(account2, 500);
//        System.out.println(account1.getBalance());
//        System.out.println(account2.getBalance());


        BankAccount accountOne = new BankAccount("02", "Anna", 700, true);
        BankAccount accountTwo = new BankAccount("03", "Mika", 800, true);

        BankSystem.addAccount(accountOne);
        BankSystem.addAccount(accountTwo);

        BankSystem.showAccounts();

//        BankAccount result = BankSystem.findAccounts("02");
//        System.out.println(result.getName());

        BankSystem.depositToAccount("02", 500);
        BankSystem.showAccounts();

        BankSystem.removeAccount();
        BankSystem.showAccounts();


//        BankSystem.withdrawFromAccount("01", 800);
//        BankSystem.showAccounts();
//
//        BankSystem.transfer("01", "02", 200);
//        BankSystem.showAccounts();





    }
}