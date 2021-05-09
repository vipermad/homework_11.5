import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Line {

  public Line(){
  }
  //ПОЛЯ
  @SerializedName("line_name")
  private String lineName;
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

//  private List<String> station = new ArrayList<>();
//
//  public Line(List<String> station) {
//    this.station = station;
//  }
//  public Line() {
//  }
//
//  public List<String> getStation() {
//    return station;
//  }
//
//  public void add(String station) {
//    this.station.add(station);
//  }

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
}
