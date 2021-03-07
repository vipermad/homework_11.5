import Interface.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Company {


  private int countEmployees;
  private List<Employee> employeeList = new ArrayList<>();
  private int income;
  public Company(int income) {
    if (income > 0 && countEmployees > 0) {
      this.income = income;
    }
  }

  public Company() {
  }

  public int getIncome() {
    income = getIncomeForCompany();
    return getIncomeForCompany();
  }

  public void setIncome(int income) {
    if (income > 0) {
      this.income = income;
    }
  }

  public int getCountEmployees() {
    return employeeList.size();
  }

  public List<Employee> getTopSalaryStaff(int count) {
    if (count > 0 && count <= employeeList.size()) {
      Collections
          .sort(employeeList, (y, x) -> Integer.compare(x.getMonthSalary(), y.getMonthSalary()));
      for (int i = 0; i < count; i++) {
        System.out.println(employeeList.get(i).getMonthSalary());
      }
      return employeeList;
    }
    return null;
  }

  public List<Employee> getLowestSalaryStaff(int count) {
    if (count > 0 && count <= employeeList.size()) {
      Collections
          .sort(employeeList, (x, y) -> Integer.compare(x.getMonthSalary(), y.getMonthSalary()));
      for (int i = 0; i < count; i++) {
        System.out.println(employeeList.get(i).getMonthSalary());
      }
      return employeeList;
    }
    return null;
  }

  public void hire(Worker position) {
    employeeList.add((Employee) position);
  }

  public void hireAll(Worker position, int countEmployees) {
    if (countEmployees > 0) {
      for (int i = 0; i < countEmployees; i++) {
        employeeList.add((Employee) position);
      }
    }
  }

  public void fire(String positionName) {
    for (int i = 0; i < employeeList.size(); i++) {
      if (employeeList.get(i).getPositionName().equals(positionName)) {
        employeeList.remove(i);
      }
    }
  }

  public void fire(int countEmployeesInPercent) {
    if (countEmployeesInPercent > 0) {
      int count = employeeList.size() * countEmployeesInPercent / 100;
      for (int i = 0; i < count; i++) {
        employeeList.remove(i);
      }
    }
  }

  public void printEmployee() {
    for (int i = 0; i < employeeList.size(); i++) {
      System.out.println(employeeList.get(i).getPositionName());
    }
  }
  private int getIncomeForCompany(){
    int x = 0;
    for (int i = 0; i < employeeList.size(); i++) {
      x = x + employeeList.get(i).getIncomeForCompany();
    }
    return x;
  }
}
