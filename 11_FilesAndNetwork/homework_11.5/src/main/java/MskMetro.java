import java.util.ArrayList;
import java.util.List;

public class MskMetro {
  public MskMetro(){}

//  private Map<String, List<String>> station = new LinkedHashMap<>();
//
//  public Map<String, List<String>> getStations() {
//    return station;
//  }
//
//  public void setStations(String lines, List<String> stations) {
//   station.put(lines, stations);
//  }
  public int getStationsCountInLine(){
    return lines.size();
  }

  private List<Line> lines = new ArrayList<>();

  public List<Line> getLines() {
    return lines;
  }

  public void setLines(String lineName , List<String> lineList) {
//    System.out.println("Название линии: " + lineName);
//    System.out.println("Список линий: " + lineList);
    lines.add(new Line(lineName, lineList));
  }
}
