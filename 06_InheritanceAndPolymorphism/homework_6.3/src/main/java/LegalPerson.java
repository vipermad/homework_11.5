public class LegalPerson extends Client {

  @Override
  public void take(double amountToTake) {
    super.take(amountToTake * 1.01);
  }
}
