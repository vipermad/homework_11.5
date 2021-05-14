import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Line {

  public Line(){
  }
  //ПОЛЯ
  @SerializedName("line_name")
  private String lineName;

  public void setStations(List<String> stations) {
    this.stations = stations;
  }

  private List<String> stations = new ArrayList<>();

  //Конструкторы
  public Line (String lineName, String nameStation){
    this.lineName = lineName;
    this.stations.add(nameStation);
  }
  public Line (String lineName, List<String> listStations){
    this.lineName = lineName;
    this.stations = listStations;
  }

//Методы
  public String getLineName() {
    return lineName;
  }

  public void setLineName(String lineName) {
    System.out.println("Название линии: "+lineName);
    this.lineName = lineName;
  }

  public List<String> getStationList() {
    return stations;
  }

  public void addStationInList(String nameStation) {
    this.stations.add(nameStation);
  }

  public void getSizeInLine(){
    System.out.println(lineName + " содержит " + stations.size() + " станций");
  }

  @Override
  public String toString() {
    return "Line{" +
        "lineName='" + lineName + '\'' +
        ", stations=" + stations +
        '}';
  }
}
