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
      Pattern pattern = Pattern
          .compile("(?<command>ADD|EDIT|DELETE|LIST)(\\s(?<index>\\d+))?(\\s(?<text>.+))?",
              Pattern.CASE_INSENSITIVE);
      Matcher matcher = pattern.matcher(input);
      if (matcher.find()) {
        if (matcher.group("command").equals("ADD")) {
          todoList.add(matcher.group("text"));
        }
        if (matcher.group("command").equals("EDIT")) {
          todoList.edit(matcher.group("text"),
              Integer.parseInt(matcher.group("index").trim()));
        }
        if (matcher.group("command").equals("DELETE")) {
          todoList.delete(Integer.parseInt(matcher.group("index").trim()));
        }
        if (matcher.group("command").equals("LIST")) {
          todoList.getTodos();
        }
      }

    }
  }
}
