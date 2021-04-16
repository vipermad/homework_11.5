import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static final String MOVEMENTS_FILE = "src/test/resources/movementListInteger.csv";

  public static void main(String[] args) throws NoSuchFileException {
    Movements movements = new Movements(MOVEMENTS_FILE);
    System.out.println(movements.getExpenseSum());
    System.out.println(movements.getIncomeSum());
  }
}
