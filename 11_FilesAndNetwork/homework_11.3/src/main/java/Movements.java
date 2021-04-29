import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Movements {

  public Movements(String pathMovementsCsv) {
    loadMovementsFromFile(pathMovementsCsv);
  }

  private List<Transaction> transactions;

  private void loadMovementsFromFile(String path) {
    try {
      CSVReader csvReader = new CSVReader(new FileReader(path));
      List<String[]> lines = csvReader.readAll();
      transactions = new ArrayList<>();
      Pattern pattern = Pattern.compile("(.*)\"(\\d+,\\d+)\"(.*)", Pattern.MULTILINE);
      //List<String> lines = Files.readAllLines(Paths.get(path));
      for (int i = 1; i < lines.size(); i++) {
        String dateFormat = "dd.MM.yy";
        transactions.add(new Transaction(
            lines.get(i)[0],
            lines.get(i)[1],
            lines.get(i)[2],
            (new SimpleDateFormat(dateFormat)).parse(lines.get(i)[3]),
            lines.get(i)[4],
            lines.get(i)[5],
            Double.parseDouble(lines.get(i)[6].replace("\"", "").replace(",", ".")),
            Double.parseDouble(lines.get(i)[7].replace("\"", "").replace(",", "."))
        ));
      }
    } catch (
        ParseException e) {
      e.printStackTrace();
    } catch (
        FileNotFoundException e) {
      e.printStackTrace();
    } catch (
        IOException e) {
      e.printStackTrace();
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
