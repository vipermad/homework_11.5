import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  private static TodoList todoList = new TodoList();

  public static void main(String[] args) {
    // TODO: написать консольное приложение для работы со списком дел todoList

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        System.out.println("EXIT");
        break;
      }
      Pattern patternAdd = Pattern.compile(".*ADD.*", Pattern.CASE_INSENSITIVE);
      Matcher matcherAdd = patternAdd.matcher(input);
      Pattern patternEdit = Pattern.compile(".*EDIT.*", Pattern.CASE_INSENSITIVE);
      Matcher matcherEdit = patternEdit.matcher(input);
      Pattern patternDelete = Pattern.compile(".*DELETE.*", Pattern.CASE_INSENSITIVE);
      Matcher matcherDelete = patternDelete.matcher(input);
      Pattern patternList = Pattern.compile(".*LIST.*", Pattern.CASE_INSENSITIVE);
      Matcher matcherList = patternList.matcher(input);
      if (matcherAdd.matches()) {
        todoList.add(input.substring(4));
      }
      if (matcherEdit.matches()) {
        todoList.edit(input.substring(7),
            Integer.parseInt(input.substring(5, 6).trim()));
      }
      if (matcherDelete.matches()) {
        todoList.delete(Integer.parseInt(input.substring(6,8).trim()));
      }
      if (matcherList.matches()) {
        todoList.getTodos();
      }
    }
  }
}
