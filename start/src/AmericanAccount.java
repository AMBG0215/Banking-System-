class AmericanAccount extends BankAccount{

        public AmericanAccount(String number, String name, float balance, boolean isActive){
            super (number, name, balance, isActive);
        }

        @Override
        public void showCurrency(){
            System.out.println("Currency: USD");
        }

}
