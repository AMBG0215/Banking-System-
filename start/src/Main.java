//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

// talks to the user
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

//        BankSystem.displayAccount("01");

//        BankSystem.withdrawFromAccount("01", 800);
//        BankSystem.showAccounts();
//
//        BankSystem.transfer("01", "02", 200);
//        BankSystem.showAccounts();

//        // POLYMORPHISM: Both variables are declared as Bank Account, but they hold different objects then the same call showCurrency() but behaves differently depending on the actual object.
//        BankAccount account1 = new FilipinoAccount("0101", "Mika", 800, true);
//        account1.showCurrency();
//        account1.deposit(1);
//        account1.withdraw(500);
//        System.out.println(account1.getBalance());
//
//
//        BankAccount account2 = new AmericanAccount("0102", "Anna", 900, true);
//        account2.showCurrency();
//        account2.deposit(500);
//        // Inheritance is when FilipinoAccount extends BankAccount and inherits its common functionality. Polymorphism is demonstrated when the same method call produces different behavior depending on the actual child object.


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
                    "9. Find Account Name" + "\n" +
                    "10. Update Name" + "\n" +
                    "11. Exit"
            );


            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter account number: ");
                    String accountNumber = scanner.nextLine();

                    BankAccount result1 = BankSystem.findAccounts(accountNumber);

                    if(result1 == null)
                    {
                        System.out.println("Enter name: ");
                        String name = scanner.nextLine();

                        System.out.println("Enter amount: ");
                        float balance = scanner.nextFloat();
                        scanner.nextLine();

                        System.out.println(
                                "Choose account type: " + "\n" +
                                "1. Savings Account" + "\n" +
                                "2. Regular Account" + "\n" +
                                "3. Student Account"
                        );
                        int accountType = scanner.nextInt();
                        scanner.nextLine();

                            if (accountType == 1){
                                BankAccount account1 = new SavingsAccount(accountNumber, name, balance, true);
                                BankSystem.addAccount(account1);
                            }else if (accountType == 2) {
                                BankAccount account2 = new BankAccount(accountNumber, name, balance, true);
                                BankSystem.addAccount(account2);
                            }else if(accountType == 3){
                                BankAccount account3 = new StudentAccount(accountNumber, name, balance, true);
                                BankSystem.addAccount(account3);
                            }else{
                                System.out.println("Invalid number");
                            }
//                        BankAccount account = new BankAccount(accountNumber, name, balance, true);
//                        BankSystem.addAccount(account);

                    }else{
                        System.out.println("Account number is already registered");
                    }

                   break;

                case 2:
                    BankSystem.showAccounts();

                    break;

                case 3:
                    System.out.println("Enter account number: ");
                    String acctNumber = scanner.nextLine();

                    BankAccount result2 = BankSystem.findAccounts(acctNumber);

                    if (result2 != null){
                        System.out.println(
                                "Account Number: " + result2.getNumber() + "\n" +
                                        "Name: " + result2.getName() + "\n" +
                                        "Balance: " + result2.getBalance() + "\n" +
                                        "Active: " + result2.isActive()
                        );
                    }else{
                        System.out.println("Account not found");
                    }

                    break;

                case 4:
                    System.out.println("Enter account number: ");
                    String acctNumber2 = scanner.nextLine();

                    System.out.println("Enter amount: ");
                    int amount1 = scanner.nextInt();
                    scanner.nextLine();

                    BankSystem.depositToAccount(acctNumber2, amount1);
                    break;

                case 5:
                    System.out.println("Enter account number: ");
                    String acctNumber3 = scanner.nextLine();

                    System.out.println("Enter amount: ");
                    int amount2 = scanner.nextInt();
                    scanner.nextLine();

                    BankSystem.withdrawFromAccount(acctNumber3, amount2);
                    break;

                case 6:
                    System.out.println("Enter account number(sender): ");
                    String senderNumber = scanner.nextLine();

                    System.out.println("Enter account number(recipient): ");
                    String recipientNumber = scanner.nextLine();

                    System.out.println("Enter amount: ");
                    int amount3 = scanner.nextInt();
                    scanner.nextLine();

                    BankSystem.transfer(senderNumber, recipientNumber, amount3);
                    break;

                case 7:
                    System.out.println("Enter account number to remove: ");
                    String removeAcc = scanner.nextLine();

                    BankSystem.removeAccount(removeAcc);
                    break;

                case 8:
                    System.out.println("Enter account number to display: ");
                    String acctNumber4 = scanner.nextLine();

                    BankSystem.displayAccount(acctNumber4);
                    break;

                case 9:
                    System.out.println("Enter name to display: ");
                    String acctName = scanner.nextLine();

                    BankSystem.findAccountsByName(acctName);
                    break;

                case 10:
                    System.out.println("Enter account number: ");
                    String acctNumber5 = scanner.nextLine();

                    System.out.println("Enter new account name: ");
                    String acctName2 = scanner.nextLine();

                    BankSystem.updateName(acctNumber5, acctName2);

                    break;

                case 11:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }








    }
}