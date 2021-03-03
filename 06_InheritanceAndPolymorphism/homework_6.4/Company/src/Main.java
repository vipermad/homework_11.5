public class Main {

  public static void main(String[] args) {
    Company company = new Company();
    company.hireAll(new Operator(), 180);
    company.hireAll(new Manager(), 80);
    company.hireAll(new TopManager(), 10);
    System.out.println(company.getCountEmployees());
    company.getTopSalaryStaff(15);
    company.getLowestSalaryStaff(30);
    company.fire(50);
    company.getTopSalaryStaff(15);
    company.getLowestSalaryStaff(30);
    System.out.println(company.getCountEmployees());
  }
}
