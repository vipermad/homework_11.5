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
    balance += amount;
    return true;
  }
}
