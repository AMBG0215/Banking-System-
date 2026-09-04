class SavingsAccount extends BankAccount {

    public SavingsAccount (String number, String name, float balance, boolean isActive){
        super(number, name, balance, isActive);
    }

    @Override
    void deposit(int amount){
        if (amount >= 100){
            System.out.println("Depositing from Savings.. ");

            super.deposit(amount);
        }else{
            System.out.println("Cannot deposit");
        }
    }

    @Override
     void withdraw(int amount){
        if(getBalance() - amount >= 100){
            // finish the logic, savings account should be with a minimum balance of P100, if the balance is 500, and withdrawed 450, it shouldn't be allowed because the minimum balance should be 100.
            System.out.println("Withdrawing from Savings.. ");
                super.withdraw(amount);

            }else{
                System.out.println("Cannot withdraw");
            }

        }


}



