
public class TopManager extends Worker {

  private double bonusAtSalary = 1.5;
  private String positionName = "TopManager";

  @Override
  public int getMonthSalary() {
    if (Company.income > 10_000_000) {
      return (int) (getSalary() * bonusAtSalary);
    }
    return 0;
  }

  @Override
  public String getPositionName() {
    return positionName;
  }
}
