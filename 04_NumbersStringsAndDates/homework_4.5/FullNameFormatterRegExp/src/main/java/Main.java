import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      int curSpace = 0;
      int count = 0;
      boolean useNumber = false;
      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) == ' ') {
          curSpace += 1;
        }
        if (Character.isDigit(input.charAt(i))) {
          useNumber = true;
          break;
        }
      }
      if (curSpace != 2 || useNumber) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      String fio[] = new String[]{"Фамилия: ", "Имя: ", "Отчество: "};
      String regex = "[a-яА-Я-]{2,20}";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);
      while (matcher.find()) {
        System.out.println(fio[count] + matcher.group());
        count++;
      }
    }
  }
}