import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

  public static void main(String[] args) throws JsonProcessingException {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      MskMetro mskMetro = new MskMetro();

      Document document = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0)
          .get();
      Element root = document.getElementById("metrodata");
      Elements elements = root.select("div[data-depend]");
      for (Element element : elements) {
        Line lineNumberName = new Line();
        String lineNumber = element.selectFirst("span[data-line]").attr("data-line");
        Element line = root.selectFirst("div[data-depend-set=\"lines-" + lineNumber + "\"]");
        Elements stantions = line.select("a[data-metrost]").select("span[class=\"name\"]");
        for (Element stantion : stantions) {
          lineNumberName.add(stantion.text());
        }
        mskMetro.setStations(lineNumber + " " + element.text(), lineNumberName.getStation());
      }

      String result = objectMapper.writeValueAsString(mskMetro);
      String path = "C:\\Users\\Александр\\IdeaProjects\\java_basics\\11_FilesAndNetwork\\homework_11.5\\src\\main\\resources\\json.json";
      File file = new File(path);
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
      ObjectMapper mapper = new ObjectMapper();
      try {
        mapper.writeValue(new File(path), mskMetro);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    //Чтение файла и вывод в консоль количество станций на каждой линии.


  }
}