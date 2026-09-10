public class Transaction {

    private String transactionId;
    private String transactionType;
    private float amount;
    private String date;

    Transaction(String transactionId, String transactionType, float amount, String date){
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date  = date;
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
