import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Movements{

  public Movements(String pathMovementsCsv) {
    loadMovementsFromFile(pathMovementsCsv);
  }

  private List<Transaction> transactions;

  private void loadMovementsFromFile(String path) {
    try {
      transactions = new ArrayList<>();
      List<String> lines = Files.readAllLines(Paths.get(path));
      for (int i = 1; i < lines.size(); i++) {
        String[] fragments = lines.get(i).split(",", 8);
        if (fragments.length != 8) {
          System.out.println("Wrong line: " + lines.get(i));
          continue;
        }
        String dateFormat = "dd.MM.yy";
        transactions.add(new Transaction(
            fragments[0],
            fragments[1],
            fragments[2],
            (new SimpleDateFormat(dateFormat)).parse(fragments[3]),
            fragments[4],
            fragments[5],
            Double.parseDouble(fragments[6].replace("\"", "").replace(",", ".")),
            Double.parseDouble(fragments[7].replace("\"", "").replace(",", "."))
        ));
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }


  public double getExpenseSum() {
    double sum = 0;
    for (int i = 0; i < transactions.size(); i++) {
      sum += transactions.get(i).getExpense();
    }
    return sum;
  }

  public double getIncomeSum() {
    double sum = 0;
    for (int i = 0; i < transactions.size(); i++) {
      sum += transactions.get(i).getIncoming();
    }
    return sum;
  }
}
