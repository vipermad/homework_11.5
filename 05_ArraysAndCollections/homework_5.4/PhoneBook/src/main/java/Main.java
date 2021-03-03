import java.util.Scanner;

public class Main {


  public static void main(String[] args) {
    PhoneBook phoneBook = new PhoneBook();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(phoneBook.greeting);
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //Если написано имя, то заходим сюда
      if (phoneBook.nameFormat(input)) {
        if (input.equalsIgnoreCase("list")) {
          phoneBook.getAllContacts();
        }
        if (!input.equalsIgnoreCase("list")) {
          phoneBook.getPhonesByName(input);
        }
      }
      if(phoneBook.phoneFormat(input)){
        phoneBook.getNameByPhone(input);
      }
    }
  }
}

