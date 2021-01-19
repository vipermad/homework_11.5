import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static EmailList emailList = new EmailList();
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0") || input.equals("exit")) {
                break;
            }
            Pattern patternAdd = Pattern.compile(".*ADD.*", Pattern.CASE_INSENSITIVE);
            Matcher matcherAdd = patternAdd.matcher(input);
            Pattern patternList = Pattern.compile(".*LIST.*", Pattern.CASE_INSENSITIVE);
            Matcher matcherList = patternList.matcher(input);
            if(matcherAdd.matches()){
                emailList.add(input.substring(4));
            }
            if (matcherList.matches()){
                emailList.getSortedEmails();
            }
            
        }
    }
}
