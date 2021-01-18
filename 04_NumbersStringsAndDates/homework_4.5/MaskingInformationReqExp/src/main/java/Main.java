import java.lang.String;
import java.util.regex.Pattern;
public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        Pattern pattern = Pattern.compile("<.+?>");
        text = text.replaceAll(String.valueOf(pattern),placeholder);
        return text;
    }

}