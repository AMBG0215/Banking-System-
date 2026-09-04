class AmericanAccount extends BankAccount{

        public AmericanAccount(String number, String name, float balance, boolean isActive){
            super (number, name, balance, isActive);
        }

        @Override
        public void showCurrency(){
            System.out.println("Currency: USD");
        }

        @Override
        void deposit(int amount){
            System.out.println("Depositing USD: " + amount);

            super.deposit(amount);
        }

        @Override
        void withdraw(int amount){
            System.out.println("Withdrawing USD: " + amount);

            super.withdraw(amount);
        }
}
