import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

//  public MskMetro parseJSON(){
//
//    JSONParser jsonParser = new JSONParser();
//    try (FileReader reader = new FileReader(DATA_FILE)) {
//      JSONObject obj = (JSONObject) jsonParser.parse(reader);
//      String lineName = (String) obj.get("line_name");
//      List<String> stations = (List) obj.get("stations");
//      System.out.println(lineName);
//      System.out.println(stations);
//      return  null;
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    } catch (IOException e) {
//      e.printStackTrace();
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
//    return null;
//  }
  public MskMetro parseJackson(){
    ObjectMapper obj = new ObjectMapper();
    return null;
  }
}
