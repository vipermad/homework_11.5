import core.Line;
import core.Station;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;


public class RouteCalculatorTest extends TestCase {

  List<Station> route;
  StationIndex stationIndex;
  RouteCalculator routeCalculator;

  @Override
  protected void setUp() throws Exception {

    route = new ArrayList<>();

    Line line1 = new Line(1, "Первая");
    Line line2 = new Line(2, "Вторая");

    route.add(new Station("Петровская", line1));
    route.add(new Station("Арбузная", line1));
    route.add(new Station("Морковная", line2));
    route.add(new Station("Яблочная", line2));

    stationIndex = new StationIndex();

    stationIndex.addLine(new Line(1, "First"));
    stationIndex.addLine(new Line(2, "Second"));
    stationIndex.addLine(new Line(3, "Third"));

    stationIndex.addStation(new Station("first_1", stationIndex.getLine(1)));
    stationIndex.addStation(new Station("first_2", stationIndex.getLine(1)));
    stationIndex.addStation(new Station("first_3", stationIndex.getLine(1)));

    stationIndex.addStation(new Station("second_1", stationIndex.getLine(2)));
    stationIndex.addStation(new Station("second_2", stationIndex.getLine(2)));
    stationIndex.addStation(new Station("second_3", stationIndex.getLine(2)));

    stationIndex.addStation(new Station("third_1", stationIndex.getLine(3)));
    stationIndex.addStation(new Station("third_2", stationIndex.getLine(3)));
    stationIndex.addStation(new Station("third_3", stationIndex.getLine(3)));
    stationIndex.addStation(new Station("third_4", stationIndex.getLine(3)));
    stationIndex.addStation(new Station("third_5", stationIndex.getLine(3)));

    stationIndex.getLine(1).addStation(stationIndex.getStation("first_1"));
    stationIndex.getLine(1).addStation(stationIndex.getStation("first_2"));
    stationIndex.getLine(1).addStation(stationIndex.getStation("first_3"));

    stationIndex.getLine(2).addStation(stationIndex.getStation("second_1"));
    stationIndex.getLine(2).addStation(stationIndex.getStation("second_2"));
    stationIndex.getLine(2).addStation(stationIndex.getStation("second_3"));

    stationIndex.getLine(3).addStation(stationIndex.getStation("third_1"));
    stationIndex.getLine(3).addStation(stationIndex.getStation("third_2"));
    stationIndex.getLine(3).addStation(stationIndex.getStation("third_3"));
    stationIndex.getLine(3).addStation(stationIndex.getStation("third_4"));
    stationIndex.getLine(3).addStation(stationIndex.getStation("third_5"));

    List<Station> connectionStations = new ArrayList<>();
    connectionStations.add(stationIndex.getStation("third_2", 3));
    connectionStations.add(stationIndex.getStation("first_2", 1));
    stationIndex.addConnection(connectionStations);

    connectionStations.clear();

    connectionStations.add(stationIndex.getStation("third_4", 3));
    connectionStations.add(stationIndex.getStation("second_2", 2));
    stationIndex.addConnection(connectionStations);
/*
                  third_1
                    |
                    |
  first_1----third_2\first_2----first_3
                    |
                    |
                  third_3
                    |
                    |
 second_1----third_4\second_2----second_3
                    |
                    |
                  third_5
*/
    routeCalculator = new RouteCalculator(stationIndex);
  }

  @Test
  public void testCalculateDuration() {
    double actual = RouteCalculator.calculateDuration(route);
    double expected = 8.5;
    assertEquals(expected, actual);
  }

  @Test
  public void testGetShortestRoute() {
    List<Station> actualRoute = routeCalculator.getShortestRoute
        (stationIndex.getStation("first_3"), stationIndex.getStation("third_3"));
    List<Station> expectedRoute = new ArrayList<Station>();
    expectedRoute.add(new Station("first_3",stationIndex.getLine(1)));
    expectedRoute.add(new Station("first_2",stationIndex.getLine(1)));
    expectedRoute.add(new Station("third_2", stationIndex.getLine(2)));
    expectedRoute.add(new Station("third_3", stationIndex.getLine(2)));
    //expectedRoute.add("third_4");
    //expectedRoute.add("second_2");
    //expectedRoute.add("second_1");
    System.out.println(expectedRoute.get(1).equals(actualRoute.get(1)));
    assertEquals(expectedRoute, actualRoute);
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }
}
