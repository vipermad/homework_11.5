import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MskMetro {
  private Map<String, List<String>> station = new LinkedHashMap<>();

  public Map<String, List<String>> getStations() {
    return station;
  }

  public void setStations(String lines, List<String> stations) {
   station.put(lines, stations);
  }
}
