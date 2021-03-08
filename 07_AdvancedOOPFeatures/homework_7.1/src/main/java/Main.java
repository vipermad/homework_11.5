import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

  public static final String STAFF_TXT = "data/staff.txt";

  public static void main(String[] args) {
    List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
    sortBySalaryAndAlphabet(staff);
  }

  public static void sortBySalaryAndAlphabet(List<Employee> staff) {
    Collections.sort(staff, (o1, o2) ->
    {
      int result = o1.getSalary().compareTo(o2.getSalary());
      if (result!=0){
        return result;
      }else{
        return o1.getName().compareTo(o2.getName());
      }
    });

    for (Employee employee : staff) {
      System.out.println(employee);
    }
  }
}