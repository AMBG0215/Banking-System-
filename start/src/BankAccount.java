
import java.util.ArrayList;

public class BankAccount {
    // Encapsulation: Keep the class's data private so outside code cannot directly
    // access or manipulate it. Instead, methods inside the class
    // control how the data is accessed or changed.


    private String number;
    private String name;
    private  float balance;
    private  boolean isActive;

    BankAccount(String number, String name, float balance, boolean isActive) {
        this.number = number;
        // this.number = the number belonging to the object being created
        // number = the value received by the constructor
        this.name = name;
        this.balance = balance;
        this.isActive = isActive;
    }

     void deposit(int amount) {
        if (isActive) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Cannot deposit");
            }
        } else {
            System.out.println("Account not active");
        }
    }

     void withdraw(int amount) {
        if (isActive) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Cannot withdraw");
            }
        } else {
            System.out.println("Account not active");
        }
    }


    void introduce() {
        System.out.println(
                "My bank account number:  " + number + "\n" +
                        "My bank account name: " + name + "\n" +
                        "My balance: " + balance + "\n" +
                        "Account status: " + isActive
        );
    }

    void transfer(BankAccount recipient, int amount) {
        if (this.isActive && recipient.isActive) {
            if (this.balance >= amount) {
                this.balance -= amount;
                recipient.balance += amount;
                System.out.println(this.getName() + " transferred " + amount + " to " + recipient.getName());
            } else {
                System.out.println("Insufficient amount of money, cannot transfer");
            }
        } else {
            System.out.println("Account is inactive");
        }
    }

    // Getter: get/read data
    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public float getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

    // Setter: change/update data
    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(float balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Cannot set");
        }

    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

}





//    BankAccount findAccount(String accountNumber){
//
//    }
//        for (BankAccount account : accounts) {
//            if (account.getNumber().equals(accountNumber)) {
//                return account;
//            }
//        }

//        public static void main (String[]args){
//
//        BankAccount account = new BankAccount("0101", "Mika", 800, true);
//
//        account.balance = 5000;
//
////        account.deposit(500);
////        account.introduce();
////        account.deposit(200);
////        account.withdraw(100);
////        account.introduce();
////        System.out.println(account.balanceNow());
//
//
////        float currentBalance = account.balanceNow();
////        System.out.println(currentBalance);
//
//
//            BankAccount result = accounts.findAccount("0102");
//        }
//    }


