import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
  private final Map<String, Customer> storage;

  public CustomerStorage() {
    storage = new HashMap<>();
  }

  public void addCustomer(String data) {
    final int INDEX_NAME = 0;
    final int INDEX_SURNAME = 1;
    final int INDEX_EMAIL = 2;
    final int INDEX_PHONE = 3;

    String[] components = data.split("\\s+");
    if (components.length != 4) {
      throw new ArrayIndexOutOfBoundsException();
    }
    String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
    if (components[INDEX_PHONE].length() != 12) {
      throw new NumberFormatException();
    }
    if (!emailFormat(components[INDEX_EMAIL])){
      throw new IllegalArgumentException();
    }
    storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
  }

  public void listCustomers() {
    storage.values().forEach(System.out::println);
  }

  public void removeCustomer(String name) {
    try {
      storage.remove(name);
    }catch (IllegalArgumentException exception){
      exception.printStackTrace();
    }

  }

  public Customer getCustomer(String name) {
    return storage.get(name);
  }

  public int getCount() {
    return storage.size();
  }
    //Почему то с этой регулярка не работает:(
  private boolean phoneFormat(String phoneNumber) {
    String regexPhoneNumber = "^7\\d{10}$";
    Pattern patternPhoneNumber = Pattern.compile(regexPhoneNumber);
    Matcher matcherPhone = patternPhoneNumber.matcher(phoneNumber);
    if (matcherPhone.find()) {
      return true;
    }
    return false;
  }

  private boolean emailFormat(String email) {
    // TODO: валидный формат email добавляется
    Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
    if (matcher.find()) {
      return true;
    }
    return false;
  }
}