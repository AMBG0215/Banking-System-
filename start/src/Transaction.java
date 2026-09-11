import java.time.LocalDate;

public class Transaction {

    private String transactionId;
    private String transactionType;
    private float amount;
    private LocalDate date;
    private BankAccount account;

    // Bank account -- transaction
    // Composition = If you design BankAccount to own its transactions, the transactions are considered part of that account.
    // Composition ("HAS-A" STRONG):
    // One class owns another object, and the child object's lifecycle
    // depends on the parent.
    // If the parent is destroyed, the child is also considered destroyed.
    // Example: A House has Rooms. If the House is destroyed,
    // the Rooms as parts of that House no longer exist.
    public Transaction(String transactionId, String transactionType, float amount, LocalDate date, BankAccount account){
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date  = date;
        this.account = account;
    }


    // Getter
    public String getTransactionId(){
        return transactionId;
    }

    public String getTransactionType(){
        return transactionType;
    }

    public float getAmount(){
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public BankAccount getAccount(){
        return account;
    }

    // Setter
    public void setTransactionId(String transactionId){
        this.transactionId = transactionId;
    }

    public void setTransactionType(String transactionType){
        this.transactionType = transactionType;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setAccount(BankAccount account){
        this.account = account;
    }


}
