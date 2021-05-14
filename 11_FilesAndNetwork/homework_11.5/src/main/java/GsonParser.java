import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GsonParser {
  private static final String DATA_FILE = "src/main/json.json";

  public MskMetro parse(){
    Gson gson = new Gson();
    try (FileReader reader = new FileReader(DATA_FILE)) {
      MskMetro gsonMskMetro = gson.fromJson(reader, MskMetro.class);
      return gsonMskMetro;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public MskMetro parseJSON(){

    try (FileReader reader = new FileReader(DATA_FILE)) {
      JsonElement fileElement = JsonParser.parseReader(reader);
      JsonObject fileObject = fileElement.getAsJsonObject();
      JsonArray jsonArray = fileObject.get("lines").getAsJsonArray();
      MskMetro mskMetro = new MskMetro();
      for (JsonElement element : jsonArray){
        List<String> station = new ArrayList<>();
        JsonObject jsonObject = element.getAsJsonObject();
        String lineName = jsonObject.get("lineName").getAsString();
        JsonArray stationsArray = jsonObject.getAsJsonArray("stationList");
        for(JsonElement elementStations : stationsArray){
          station.add(elementStations.toString().replace('\"',' ').trim());
        }
        Line line = new Line(lineName, station);
        mskMetro.addLine(line);
      }

      return  mskMetro;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
