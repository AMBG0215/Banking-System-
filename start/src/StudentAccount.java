class StudentAccount extends BankAccount {

        public StudentAccount(String number, String name, float balance, boolean isActive){
            super(number, name, balance, isActive);
        }

        @Override
         public void showAccountType(){
            System.out.println("Account Type: " + "Student Account");
        }





}
