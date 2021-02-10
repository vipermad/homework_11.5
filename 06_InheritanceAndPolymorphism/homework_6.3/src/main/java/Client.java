public abstract class Client {

    private double balance;

    public double getAmount() {
        return balance;
    }

    public void put(double amountToPut) {
        if(amountToPut< 0){
            System.out.println("Amount to put cannot be less than zero.");
        } else{
            balance += amountToPut;
        }
    }

    public void take(double amountToTake) {
        //TODO: реализуйте метод и удалите todo
        if (balance<amountToTake){
            System.out.println("Amount cannot be more than the account balance");
        }else {
            balance -=amountToTake;
        }
    }

}
