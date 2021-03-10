import java.text.ParseException;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main {

  private static final String STAFF_TXT = "data/staff.txt";


  public static void main(String[] args) throws ParseException {
    List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
    Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
    System.out.println(employeeMaxSalary);
  }

  public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
    //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
    // кто пришёл в году, указанном в переменной year
    return staff.stream().filter(employee -> getYear(employee.getWorkStart()) == year)
            .max(Comparator.comparing(Employee::getSalary))
            .orElse(null);
  }
  private static int getYear(Date date){
    return date.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate()
        .getYear();
  }
}