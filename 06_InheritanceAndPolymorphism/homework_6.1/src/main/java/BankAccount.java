public class BankAccount {

  protected double balance = 0;

  public double getAmount() {
    if (balance > 0) {
      return balance;
    }
    return 0;
  }

  public void put(double amountToPut) {
    if (amountToPut>0){
      balance += amountToPut;
    }
  }

  public void take(double amountToTake) {
    if (balance>= amountToTake && amountToTake>0) {
      balance -= amountToTake;
    }
  }

  public boolean send(BankAccount receiver, double amount){

    if (balance >= amount && amount>0){
      take(amount);
      receiver.put(amount);
      return true;
    }
    return false;
  }
}
