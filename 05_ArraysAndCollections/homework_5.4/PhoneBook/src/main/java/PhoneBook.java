import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneBook {

  TreeMap<String, String> contacts = new TreeMap<>();
  public boolean nameFormat(String input) {
    String regexName = "[a-яА-Я-]{2,20}";
    Pattern patternName = Pattern.compile(regexName);
    Matcher matcherName = patternName.matcher(input);
    if (matcherName.find()) {
      return true;
    }
    return false;
  }
  public boolean phoneFormat(String input) {
    String regexPhoneNumber = "[0-9]{11}";
    Pattern patternPhoneNumber = Pattern.compile(regexPhoneNumber);
    Matcher matcherPhone = patternPhoneNumber.matcher(input);
    if (matcherPhone.find()) {
      return true;
    }
    return false;
  }
  public static String greeting = "Введите номер, имя или команду:";
  private static String noName = "Такого имени в телефонной книге нет.";
  private static String noPhone = "Такого номера нет в телефонной книге.";
  Scanner scanner = new Scanner(System.in);

  public void addContact(String phone, String name) {
    if (nameFormat(name) && phoneFormat(phone)) {
      if (contacts.containsKey(phone)) {
        contacts.replace(phone, name);
      } else {
        contacts.put(phone, name);
        System.out.println("Контакт сохранен!");
      }
    }
  }

  public String getNameByPhone(String phone) {
    if (contacts.containsKey(phone)) {
      System.out.printf("%s - %s\n", contacts.get(phone), phone);
      return contacts.get(phone) + " - " + phone;
    }
    System.out.println(noPhone);
    System.out.printf("Введите имя абонента для номера \"%s\"\n", phone);
    String name = scanner.nextLine();
    addContact(phone,name);
    return "";
  }
  public Set<String> getPhonesByName(String name) {
    if (!contacts.containsValue(name)) {
      System.out.println(noName);
      System.out.printf("Введите номер телефона для абонента \"%s\"\n", name);
      String phone = scanner.nextLine();
      addContact(phone,name);
      return new TreeSet<>();
    } else {
      Set<String> phoneByName = new TreeSet<>();
      for (String key:contacts.keySet()){
        if (contacts.get(key).equals(name)){
          phoneByName.add(name + " - " + key);
          System.out.println(name + " - " + key);
          return phoneByName;
        }
      }
    }
    return new TreeSet<>();
  }
  public Set<String> getAllContacts() {
    if (!contacts.isEmpty()) {
      Set<String> allContacts = new TreeSet<>();
      for (Map.Entry<String, String> item:contacts.entrySet()){
        allContacts.add(item.getValue() + " - " + item.getKey());
        System.out.println(item.getValue() + " - " + item.getKey());
      }
      return allContacts;
    }
    return new TreeSet<>();
  }
}