
public class Operator extends Worker {

  private String positionName = "Operator";

  @Override
  public int getMonthSalary() {
    return getSalary();
  }

  @Override
  public String getPositionName() {
    return positionName;
  }
}
