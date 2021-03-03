
public class Manager extends Worker{
  private double bonusAtInncome = 0.05;
  private String positionName="Manager";

  @Override
  public int getMonthSalary() {
    return (int) ((int) getSalary() * bonusAtInncome + getSalary());
  }

  public String getPositionName(){
    return positionName;
  }
}
