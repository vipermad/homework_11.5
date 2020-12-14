public class Main {

  public static void main(String[] args) {

  }

  public static String splitTextInToWords(String text) {
    //TODO реализуйте метод
    return text.replaceAll("[\n.,;0-9]", "").replaceAll
        ("[\\s]{2,}", " ").replaceAll("[\s-]", "\n");
  }

}