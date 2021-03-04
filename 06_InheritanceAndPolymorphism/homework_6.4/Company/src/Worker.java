import Interface.Employee;

public abstract class Worker implements Employee {

  private int Salary = 50_000;
  private int incomeForCompany = 0;


  public void setMonthSalary(int monthSalary) {
    if (monthSalary > 0) {
      this.Salary = monthSalary;
    }
  }

  protected int getSalary() {
    return Salary;
  }

  public Worker(){
  }
  public Worker(int Salary){
    this.Salary = Salary;
  }
  public int getIncomeForCompany(){
    return incomeForCompany;
  }
}
