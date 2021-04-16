import java.util.Date;
import java.util.List;
import lombok.Getter;

@Getter
public class Transaction {

  private String accountType;
  private String accountNumber;
  private String currency;
  private Date dateOfOperation;
  private String transactionReference;
  private String operationDescription;
  private Double incoming;
  private Double expense;

  public Transaction(String accountType,
      String accountNumber,
      String currency,
      Date dateOfOperation,
      String transactionReference,
      String operationDescription,
      Double incoming,
      Double expense) {
    this.accountType = accountType;
    this.accountNumber = accountNumber;
    this.currency = currency;
    this.dateOfOperation = dateOfOperation;
    this.transactionReference = transactionReference;
    this.operationDescription = operationDescription;
    this.incoming = incoming;
    this.expense = expense;
  }
}
