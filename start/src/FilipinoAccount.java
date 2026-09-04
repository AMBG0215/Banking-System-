class FilipinoAccount extends BankAccount{
        // INHERITANCE: Filipino Account inherits accessible fields and methods from Bank Account BUT IT DOESN'T INHERIT THE CONSTRUCTOR.
        // Constructors are not inherited, which is why you create the FilipinoAccount constructor and use super(...).
        // That's why you still need to write the constructor: "Call the constructor of my parent class (BankAccount) and initialize the parent part using these values."
        public FilipinoAccount(String number, String name, float balance, boolean isActive){
            super(number, name, balance, isActive);
            // super refers to and calls the constructor of the parent class (BankAccount).
            // think of it as super(BankAccount(String number, String name, float balance, boolean isActive))
        }

        // POLYMORPHISM: One thing can take many forms. The same method call can behave differently depending on the actual object.
        // You have a parent void showCurrency() and different children showCurrency() from Filipino Account and American Account. The same method call produces different results.
        @Override
        // This method already exists in my parent class, and I want to replace its behavior in this child class.
        public void showCurrency() {
            System.out.println("Currency: PHP");
        }

        @Override

        void deposit(int amount){
            System.out.println("Depositing PHP " + amount);
            // Parent's original deposit method: call the original deposit() method from the parent class.
            super.deposit(amount);
        }

        @Override
        void withdraw(int amount){
            // Child's additional behavior
            System.out.println("Withdrawing PHP " + amount);

            // run the parent's original deposit logic.
            super.withdraw(amount);

            // Question: what's the purpose of running the parent if there's a child? The child class doesn't necessarily replace everything from the parent. It inherits and reuses common functionality.

        }



}
