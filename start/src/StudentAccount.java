class StudentAccount extends BankAccount {

        public StudentAccount(String number, String name, float balance, boolean isActive){
            super(number, name, balance, isActive);
        }

        @Override
         public void showAccountType(){
            System.out.println("Account Type: " + "Student Account");
        }

        @Override
        void deposit(int amount){
            if (amount > 10000){
                System.out.println("Cannot deposit, 10000 is the maximum");
            }else{
                System.out.println("Depositing from Student..");
                super.deposit(amount);
            }
        }

        @Override
        void withdraw(int amount){
            System.out.println("Withdrawing from Student Account.. ");
            super.withdraw(amount);
        }


}
