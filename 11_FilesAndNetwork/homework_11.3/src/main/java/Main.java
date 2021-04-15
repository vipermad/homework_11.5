import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static final String MOVEMENTS_FILE = "src/test/resources/movementList.csv";

  public static void main(String[] args) throws IOException {
    String line = Files.readString(Paths.get(MOVEMENTS_FILE));
    System.out.println(line);
//    //List<Movements> extract = Movements.loadMovementsFromFile(MOVEMENTS_FILE);
//    System.out.println(extract.isEmpty());
//    System.out.println(extract.get(1).getOperationDescription());
//    for (Movements movements: extract
//    ) {
//      System.out.println(movements.getAccountNumber());
//      System.out.println(movements.getCurrency());
//      System.out.println(movements.getExpense());
//      System.out.println(movements.getOperationDescription());
//    }
  }
}
