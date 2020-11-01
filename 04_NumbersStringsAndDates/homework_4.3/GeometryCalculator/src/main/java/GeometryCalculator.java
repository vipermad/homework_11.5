import java.rmi.MarshalException;

public class GeometryCalculator {

  // метод должен использовать абсолютное значение radius
  public static double getCircleSquare(double radius) {

    return Math.abs(Math.PI * Math.pow(radius, 2));
  }

  // метод должен использовать абсолютное значение radius
  public static double getSphereVolume(double radius) {

    return Math.abs(4. / 3. * Math.PI * Math.pow(radius, 3));
  }

  public static boolean isTrianglePossible(double a, double b, double c) {
    if (a + b > c && a + c > b && c + b > a) {
      return true;
    } else {
      return false;
    }
  }

  // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
  // методом isTrianglePossible, если невозможен вернуть -1.0
  public static double getTriangleSquare(double a, double b, double c) {
    if (isTrianglePossible(a, b, c)) {
      double halfMeter = (a + b + c) / 2.;
      double S = Math.sqrt(halfMeter*((halfMeter-a)*(halfMeter-b)*(halfMeter-c)));
      return S;
    } else {
      return -1;
    }
  }
}
