import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

  public static void main(String[] args) {

    int day = 31;
    int month = 12;
    int year = 1990;

    System.out.println(collectBirthdays(year, month, day));

  }

  public static String collectBirthdays(int year, int month, int day) {

    //TODO реализуйте метод для построения строки в следующем виде
    //0 - 31.12.1990 - Mon
    //1 - 31.12.1991 - Tue
    String birthday = "";
    int count = 0;

    LocalDate localDate = LocalDate.of(year, month, day);//For reference
    DateTimeFormatter formatter = DateTimeFormatter
        .ofPattern("dd.MM.yyyy - E", Locale.ENGLISH);

    if (localDate.isAfter(LocalDate.now())) {
      return "";
    }
    while (!localDate.isAfter(LocalDate.now()) || localDate.isEqual(LocalDate.now())) {
      birthday += count + " - " + localDate.format(formatter) + "\n";
      localDate = localDate.plusYears(1);
      count++;
    }
    return birthday;
  }
}
