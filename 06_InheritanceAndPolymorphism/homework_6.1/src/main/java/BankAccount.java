public class BankAccount {

  protected double balance = 0;

  public double getAmount() {
    if (balance > 0) {
      return balance;
    }
    return 0;
  }

  public void put(double amountToPut) {
    balance += amountToPut;
  }

  public void take(double amountToTake) {
    if (balance>= amountToTake) {
      balance -= amountToTake;
    }
  }

  public boolean send(BankAccount receiver, double amount){

    if (balance >= amount){
      balance -= amount;
      receiver.balance += amount;
      return true;
    }
    return false;
  }
}
