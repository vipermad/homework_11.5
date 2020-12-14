import java.util.Scanner;

public class Main {


  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      int curSpace = 0;
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
      String[] fio = input.split(" ");
      for (int i = 0; i < fio.length; i++) {
        switch (i) {
          case 0:
            System.out.println("Фамилия: " + fio[i]);
            continue;
          case 1:
            System.out.println("Имя: " + fio[i]);
            continue;
          case 2:
            System.out.println("Отчество: " + fio[i]);
            continue;
        }
      }
    }
  }
}