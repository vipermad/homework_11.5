import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  private static boolean nameFormat(String input){
    String regexName = "[a-яА-Я-]{2,20}";
    Pattern patternName = Pattern.compile(regexName);
    Matcher matcherName = patternName.matcher(input);
    if (matcherName.find()){
      return true;
    }
    return false;
  }
  private static boolean phoneFormat(String input){
    String regexPhoneNumber = "[0-9]{11}";
    Pattern patternPhoneNumber = Pattern.compile(regexPhoneNumber);
    Matcher matcherPhone = patternPhoneNumber.matcher(input);
    if (matcherPhone.find()){
      return true;
    }
    return false;
  }
  private static String greeting = "Введите номер, имя или команду:";
  private static String noName = "Такого имени в телефонной книге нет." ;
  private static String noPhone = "Такого номера нет в телефонной книге.";

  public static void main(String[] args) {
    PhoneBook phoneBook = new PhoneBook();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(greeting);
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //Если написано имя, то заходим сюда
      if (nameFormat(input)){
        if (input.equalsIgnoreCase("list")){
          phoneBook.getAllContacts();
        }
        if (!input.equalsIgnoreCase("list")) {
          phoneBook.getPhonesByName(input);
        }
      }
      if (phoneFormat(input)){

      }
    }
  }

}
