import java.time.LocalDateTime;

public class DepositAccount extends BankAccount {
  private LocalDateTime lastIncome = LocalDateTime.now();
  @Override
  public void take(double amountToTake) {
    if (balance >= amountToTake && LocalDateTime.now().isAfter(lastIncome.minusMonths(1))){
      super.take(amountToTake);
      lastIncome = LocalDateTime.now();
    }

  }
}
