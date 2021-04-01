import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.println("Введите путь до папки:");
            try {
                Scanner scanner = new Scanner(System.in);
                String inputLine = scanner.nextLine();
                System.out.println("Размер папки " + inputLine + " составляет " +
                    FileUtils.calculateFolderSize(inputLine) + FileUtils.sizeWeight());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
