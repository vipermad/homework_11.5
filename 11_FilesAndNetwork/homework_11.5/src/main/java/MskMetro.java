import java.util.ArrayList;
import java.util.List;

public class MskMetro {
  private List<Line> line = new ArrayList<>();

  public List<Line> getLine() {
    return line;
  }

  public void setLine(Line line) {
    this.line.add(line);
  }
}
