import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Movements {

  private String accountType;
  private String accountNumber;
  private String currency;
  private String dateOfOperation;
  private String transactionReference;
  private String operationDescription;
  private Integer incoming;
  private Integer expense;

  public Movements(String accountType,
      String accountNumber,
      String currency,
      String dateOfOperation,
      String transactionReference,
      String operationDescription,
      Integer incoming,
      Integer expense) {
    this.accountType = accountType;
    this.accountNumber = accountNumber;
    this.currency = currency;
    this.dateOfOperation = dateOfOperation;
    this.transactionReference = transactionReference;
    this.operationDescription = operationDescription;
    this.incoming = incoming;
    this.expense = expense;
  }
  public Movements(String path){
    loadMovementsFromFile(path);
  }

    public static List<Movements> loadMovementsFromFile(String path) {
        List<Movements> movements = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));

            for (String line : lines) {
                String[] fragments = line.split(",");
                if (fragments.length != 8) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                String dateFormat = "dd.MM.yy";
              System.out.println(fragments[6]);
              System.out.println(fragments[6].length());
                movements.add(new Movements(
                    fragments[0],
                    fragments[1],
                    fragments[2],
                    fragments[3],
                    fragments[4],
                    fragments[5],
                    Integer.parseInt(fragments[6]),
                    Integer.parseInt(fragments[7])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return movements;
    }

  public double getExpenseSum() {

      return 0.0;
  }

  public double getIncomeSum() {

      return 0.0;
  }
}
