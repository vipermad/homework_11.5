import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Введите путь до копируевой папки:");
      String sourceInput =  scanner.nextLine();
      System.out.println("Введите путь куда копировать:");
      String destInput = scanner.nextLine();
      FileUtils.copyFolder(sourceInput,destInput);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
