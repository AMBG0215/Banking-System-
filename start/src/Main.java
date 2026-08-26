//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

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

//        BankAccount accountOne = new BankAccount("02", "Anna", 700, true);
//        BankAccount accountTwo = new BankAccount("03", "Mika", 800, true);
//
//        BankSystem.addAccount(accountOne);
//        BankSystem.addAccount(accountTwo);
//
//        BankSystem.showAccounts();

//        BankAccount result = BankSystem.findAccounts("02");
//        System.out.println(result.getName());

//        BankSystem.depositToAccount("02", 500);
//        BankSystem.showAccounts();

        BankSystem.displayAccount("01");



//        BankSystem.withdrawFromAccount("01", 800);
//        BankSystem.showAccounts();
//
//        BankSystem.transfer("01", "02", 200);
//        BankSystem.showAccounts();

        boolean isRunning = true;

        while (isRunning) {

            System.out.println(
                    "1. Add Account" + "\n" +
                    "2. Show Accounts" + "\n" +
                    "3. Find Account" + "\n" +
                    "4. Deposit" + "\n" +
                    "5. Withdraw" + "\n" +
                    "6. Transfer" + "\n" +
                    "7. Remove Account" + "\n" +
                    "8. Show Account" + "\n" +
                    "9. Exit"
            );


            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter account number: ");
                    String accountNumber = scanner.nextLine();

                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter amount: ");
                    float balance = scanner.nextFloat();
                    scanner.nextLine();

                   BankAccount account = new BankAccount(accountNumber, name, balance, true);
                   BankSystem.addAccount(account);

                   break;

                case 2:
                    BankSystem.showAccounts();

                    break;

                case 3:
                    // Fix the logic here, not yet done. 
                    System.out.println("Enter account number: ");
                    String acctNumber = scanner.nextLine();

                    break;

                case 9:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }








    }
}