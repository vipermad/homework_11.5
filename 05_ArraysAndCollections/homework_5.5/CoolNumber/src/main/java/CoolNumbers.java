import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class CoolNumbers {

  private static String[] allowedChars =
      new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

  public static int rnd(int min, int max) {
    max -= min;
    return (int) (Math.random() * ++max) + min;
  }

  public static List<String> generateCoolNumbers() {
    List<String> numbers = new ArrayList<>();
    for (int i = 0; i < 2000000; i++) {
      int digits = (int) Math.round(Math.random() * 1000);
      String digitsStr = Integer.toString(digits);
      if (digits < 100 && digits > 9) {
        digitsStr = "0" + digitsStr;
      }
      if (digits < 10 && digits > 0) {
        digitsStr = "00" + digitsStr;
      }

      int firstChar = (int) Math.floor(Math.random() * allowedChars.length);
      int secondChar = (int) Math.floor(Math.random() * allowedChars.length);
      int thirdChar = (int) Math.floor(Math.random() * allowedChars.length);

      int regions = rnd(0, 200);
      String regionStr = Integer.toString(regions);
      if (regions < 10) {
        regionStr = "0" + regionStr;
      }

      numbers.add(allowedChars[firstChar] + digitsStr + allowedChars[secondChar] +
          allowedChars[thirdChar] + regionStr);
    }
    return numbers;
  }

  public static boolean bruteForceSearchInList(List<String> list, String number) {
    long startTime = System.nanoTime();
    long endTime;
    long timeSearch;
    for (String item :list) {
      if (item.equals(number)){
        endTime = System.nanoTime();
        timeSearch = endTime-startTime;
        System.out.println(timeSearch);
        return true;
      }
    }
    return false;
  }

  public static boolean binarySearchInList(List<String> sortedList, String number) {
    long endTime;
    long timeSearch;
    Collections.sort(sortedList);
    long startTime = System.nanoTime();
    if (Collections.binarySearch(sortedList, number) >= 0){
      endTime = System.nanoTime();
      timeSearch = endTime-startTime;
      System.out.println(timeSearch);
      return true;
    }
    return false;
  }


  public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
    long startTime = System.nanoTime();
    long endTime;
    long timeSearch;
    if (hashSet.contains(number)){
      endTime = System.nanoTime();
      timeSearch = endTime-startTime;
      System.out.println(timeSearch);
      return true;
    }
    return false;
  }

  public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
    long startTime = System.nanoTime();
    long endTime;
    long timeSearch;
    if (treeSet.contains(number)){
      endTime = System.nanoTime();
      timeSearch = endTime-startTime;
      System.out.println(timeSearch);
      return true;
    }
    return false;
  }

}
