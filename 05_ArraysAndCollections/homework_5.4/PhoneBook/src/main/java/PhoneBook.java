import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

  TreeMap<String, String> contacts = new TreeMap<>();

  public void addContact(String phone, String name) {
    // проверьте корректность формата имени и телефона
    // если такой номер уже есть в списке, то перезаписать имя абонента
  }

  public String getNameByPhone(String phone) {
    // формат одного контакта "Имя - Телефон"
    if (contacts.keySet().isEmpty()) {
      return "";
    } else {
      for (String key : contacts.keySet()) {
        if (contacts.get(key).equals(phone)) {
          System.out.println(key);
          return key;
        }
      }
    }
    // если контакт не найдены - вернуть пустую строку
    return "";
  }

  public Set<String> getPhonesByName(String name) {
    // формат одного контакта "Имя - Телефон"
    System.out.println(name + "" + contacts.get(name));
    // если контакт не найден - вернуть пустой TreeSet
    return new TreeSet<>();
  }

  public Set<String> getAllContacts() {
    // формат одного контакта "Имя - Телефон"
    if (!contacts.isEmpty()){
      return (Set<String>) contacts;
    }
    // если контактов нет в телефонной книге - вернуть пустой TreeSet
    return new TreeSet<>();
  }

}