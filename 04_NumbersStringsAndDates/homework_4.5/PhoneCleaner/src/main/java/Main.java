import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      String numberPhone;
      //убираем лишние символы(+-())
      numberPhone = input.replaceAll("[^0-9]", "");
      //Если первый симво 8-ка, то заменяем её на 7-ку
      if (numberPhone.charAt(0) == '8' && numberPhone.length() == 11) {
        numberPhone = numberPhone.replace(numberPhone.charAt(0), '7');
      }
      //если длина всего 10 сиволов, значит не хватает кода страны. Добавляем.
      if (numberPhone.length() == 10) {
        numberPhone = '7' + numberPhone;
      }
      //Проверяем на длину номера телефона и на корректный код страны.
      if (numberPhone.length() != 11) {
        System.out.println("Неверный формат номера");
      } else if (numberPhone.charAt(0) != '7') {
        System.out.println("Неверный формат номера");
      } else {
        System.out.println(numberPhone);
      }
    }
  }

}
