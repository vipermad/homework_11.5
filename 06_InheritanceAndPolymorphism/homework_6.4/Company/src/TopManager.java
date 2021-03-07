
public class TopManager extends Worker {

  private double bonusAtSalary = 1.5;
  private String positionName = "TopManager";
  private Company myCompany;

  public TopManager(Company company){
    this.myCompany = company;
  }

  @Override
  public int getMonthSalary() {
    if (myCompany.getIncome() > 10_000_000) {
      return (int) (getSalary() * bonusAtSalary);
    }
    return 0;
  }

  @Override
  public String getPositionName() {
    return positionName;
  }
}
