public class Main {

  public static void main(String[] args) {


  }
  
  private static boolean isDigit(String s) throws NumberFormatException {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    int sum = 0;
    String words[] = text.split(" ");
    for (int i = 0; i < words.length; i++) {
      if (isDigit(words[i])){
        sum += Integer.parseInt(words[i]);
      }
    }
    return sum;
  }

}