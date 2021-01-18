public class Main {

  public static void main(String[] args) {

  }

  public static String searchAndReplaceDiamonds(String text, String placeholder) {
    // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
    //Проверка на ввод
    int count = 0;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == '<') {
        count += 1;
      }
      if (text.charAt(i) == '>') {
        count += 1;
      }
    }
    if (count == 0) {
      return text;
    }
    //Проверка на ввод
    if (text.indexOf('<') > 0 && text.indexOf('>') > 0) {
      //Основная логика замены
      text = text.replace(text.substring(text.indexOf('<'), text.indexOf('>') + 1), placeholder);
      //Проверка на ввод
      if (count == 4) {
        //Основная логика замены
        text = text.replace(text.substring(text.lastIndexOf('<'), text.lastIndexOf('>') + 1),
            placeholder);
      }
    }
    return text;
  }

}