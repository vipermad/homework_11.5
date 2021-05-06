import java.util.ArrayList;
import java.util.List;

public class Line {

  private List<String> station = new ArrayList<>();

  public Line(List<String> station) {
    this.station = station;
  }
  public Line() {
  }

  public List<String> getStation() {
    return station;
  }

  public void add(String station) {
    this.station.add(station);
  }
}
