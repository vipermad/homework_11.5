import com.opencsv.CSVReader;
import java.nio.file.NoSuchFileException;

public class Main {

  public static final String MOVEMENTS_FILE = "src/test/resources/movementList.csv";

  public static void main(String[] args) throws NoSuchFileException {
    Movements movements = new Movements(MOVEMENTS_FILE);
    System.out.println(movements.getExpenseSum());
    System.out.println(movements.getIncomeSum());

  }
}
