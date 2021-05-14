import java.util.ArrayList;
import java.util.List;

public class MskMetro {
  public MskMetro(){}
  public MskMetro(String lineName, List<String> station){
    lines.add(new Line(lineName, station));
  }

  public int getStationsCountInLine(){
    return lines.size();
  }

  public void addLine(Line line) {
    this.lines.add(line);
  }

  private List<Line> lines = new ArrayList<>();

  public List<Line> getLines() {
    return lines;
  }

  public void setLines(String lineName , List<String> lineList) {
    lines.add(new Line(lineName, lineList));
  }

  @Override
  public String toString() {
    return "MskMetro{" +
        "lines=" + lines +
        '}';
  }

}
