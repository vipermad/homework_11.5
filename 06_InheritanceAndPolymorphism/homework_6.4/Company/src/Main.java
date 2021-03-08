public class Main {

  public static void main(String[] args) {
    Company company = new Company();
    company.hireAll(new Operator(), 5);
    company.hireAll(new Manager(), 5);
    company.hireAll(new TopManager(company), 1);
    System.out.println(company.getCountEmployees());
    System.out.println("топ зарплат");
    company.getTopSalaryStaff(11);
    company.printEmployee();
    System.out.println("топ зарплат с конца");
    company.getLowestSalaryStaff(11);
    company.fire(50);
    company.getTopSalaryStaff(15);
    company.getLowestSalaryStaff(30);
    System.out.println(company.getIncome());


  }
}
