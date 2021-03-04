
public class Manager extends Worker {

  private double bonusAtInncome = 0.05;
  private String positionName = "Manager";
  private int incomeForCompany = (int) Math.round(Math.random() * 100000);

  @Override
  public int getMonthSalary() {
    return (int) ((int) getSalary() * bonusAtInncome + getSalary());
  }

  public String getPositionName() {
    return positionName;
  }

  @Override
  public int getIncomeForCompany() {
    return incomeForCompany;
  }

}
