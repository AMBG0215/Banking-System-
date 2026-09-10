public class Transaction {

    private String transactionId;
    private String transactionType;
    private float amount;
    private String date;
    private BankAccount account;

    Transaction(String transactionId, String transactionType, float amount, String date, BankAccount account){
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date  = date;
        this.account = account;
    }

    public void showTransaction(){
        System.out.println("Hello from transaction");
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

    public String getDate(){
        return date;
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

    public void setDate(String date){
        this.date = date;
    }



}
