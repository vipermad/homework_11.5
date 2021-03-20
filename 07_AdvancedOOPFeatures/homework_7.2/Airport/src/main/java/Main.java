import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import com.skillbox.airport.Flight.Type;
import com.skillbox.airport.Terminal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.text.TableView.TableRow;
import net.sf.saxon.functions.CollectionFn;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        findPlanesLeavingInTheNextTwoHours(airport).stream().forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        LocalTime todayLocal = LocalTime.now();
        return airport.getTerminals().stream()
            .flatMap(terminal -> terminal.getFlights().stream())
            .filter(flight -> flight.getType().equals(Type.DEPARTURE))
            .filter(time -> time.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime().isAfter(todayLocal))
            .filter(time -> time.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime().isBefore(todayLocal.plusHours(2)))
            .collect(Collectors.toList());
    }

} 