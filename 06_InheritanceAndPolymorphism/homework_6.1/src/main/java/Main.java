public class Main {
  public static void main (String args []){
    CardAccount cardAccount = new CardAccount();
    DepositAccount depositAccount = new DepositAccount();
    BankAccount bankAccount = new BankAccount();
    cardAccount.put(1000);
    cardAccount.send(depositAccount, 200);
    bankAccount.put(1005);


    System.out.println("Card: " + cardAccount.getAmount());
    System.out.println("Deposit: " + depositAccount.getAmount());
    System.out.println("BankAccount: " + bankAccount.getAmount());
  }
}
