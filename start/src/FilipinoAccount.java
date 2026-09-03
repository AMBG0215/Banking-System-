class FilipinoAccount extends BankAccount{
        // Filipino Account inherits from Bank Account BUT IT DOESN'T INHERIT THE CONSTRUCTOR ONLY THE METHODS.

        // That's why you still need to write the constructor: "Call the constructor of my parent class (BankAccount) and initialize the parent part using these values."
        public FilipinoAccount(String number, String name, float balance, boolean isActive){
            super(number, name, balance, isActive);
            // super refers to and calls the constructor of the parent class (BankAccount).
            // think of it as super(BankAccount(String number, String name, float balance, boolean isActive))
        }

        @Override
        // This method already exists in my parent class, and I want to replace its behavior in this child class.
        public void showCurrency() {
            System.out.println("Currency: PHP");
        }

        @Override

        void deposit(int amount){
            System.out.println("Depositing: PHP");
            // Parent's original deposit method: call the original deposit() method from the parent class.
            super.deposit(amount);
        }

        @Override
        void withdraw(int amount){
            System.out.println("Withdrawing: PHP");

            super.withdraw(amount);
        }



}
