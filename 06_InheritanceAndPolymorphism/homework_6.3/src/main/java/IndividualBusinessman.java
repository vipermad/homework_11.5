public class IndividualBusinessman extends Client {
  private static final double COMMISION_BEFORE_1000 = 0.99;
  private static final double COMMISION_AFTER_1000 = 0.995;

  @Override
  public void put(double amountToPut) {
    if (amountToPut < 1000) {
      super.put(amountToPut * COMMISION_BEFORE_1000);
    }
    if (amountToPut >= 1000){
      super.put(amountToPut * COMMISION_AFTER_1000);
    }
  }
}
