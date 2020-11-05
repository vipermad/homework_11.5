import java.io.UnsupportedEncodingException;

public class Main {

  public static void main(String[] args) throws UnsupportedEncodingException {
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (int i = 0; i < alphabet.length(); i++) {
      System.out.println(alphabet.charAt(i) + " имеет код - " + alphabet.codePointAt(i));
    }
  }

}
