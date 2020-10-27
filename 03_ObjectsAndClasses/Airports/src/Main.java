import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        int numberOfAircraft = airport.getAllAircrafts().size();
        airport.getAllAircrafts().forEach(System.out::println);
        System.out.println("Всего самолетов: " + numberOfAircraft);
    }
}
