import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
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
      String surname = "";
      String name = "";
      String patronymic = "";
      int spaceIndex = input.indexOf(' ');
      int spaceIndexLast = input.lastIndexOf(' ');
      surname = input.substring(0, spaceIndex).trim();
      name = input.substring(spaceIndex, spaceIndexLast).trim();
      patronymic = input.substring(spaceIndexLast).trim();

      System.out.printf("Фамилия: %s%nИмя: %s%nОтчество: %s", surname, name, patronymic);
    }
  }

}