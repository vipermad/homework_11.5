import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
}
