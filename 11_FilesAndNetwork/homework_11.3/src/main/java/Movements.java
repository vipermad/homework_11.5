import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
      Pattern pattern = Pattern.compile("(.*)\"(\\d+,\\d+)\"(.*)", Pattern.MULTILINE);
      List<String> lines = Files.readAllLines(Paths.get(path));
      for (int i = 1; i < lines.size(); i++) {
        Matcher matcher = pattern.matcher(lines.get(i));
        String[] fragments;
        if (matcher.find()){
          String text =  lines.get(i).replace(matcher.group(2),matcher.group(2).replace(",", "."));
          fragments = text.split(",");
        } else {
          fragments = lines.get(i).split(",");
        }
        System.out.println(fragments[7]);
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
