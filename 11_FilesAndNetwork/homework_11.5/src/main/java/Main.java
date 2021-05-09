import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

  private static final String DATA_FILE = "src/main/json.json";

  public static void main(String[] args) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      MskMetro mskMetro = new MskMetro();

      Document document = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0)
          .get();
      Element root = document.getElementById("metrodata");
      Elements elements = root.select("div[data-depend]");
      for (Element element : elements) {
        Line lineName = new Line();
        String lineNumber = element.selectFirst("span[data-line]").attr("data-line");
        Element line = root.selectFirst("div[data-depend-set=\"lines-" + lineNumber + "\"]");
        Elements stantions = line.select("a[data-metrost]").select("span[class=\"name\"]");
        //lineName.setLineName(lineNumber + " " + element.text());
        for (Element stantion : stantions) {
          lineName.addStationInList(stantion.text());
        }
        mskMetro.setLines(lineNumber + " " + element.text(), lineName.getStationList());
        //mskMetro.setLines(lineNumber + " " + element.text(), lineName.getStationList());
      }

      File file = new File(DATA_FILE);
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
      ObjectMapper mapper = new ObjectMapper();
      try {
        mapper.writeValue(new File(DATA_FILE), mskMetro);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    //Чтение файла и вывод в консоль количество станций на каждой линии.
    System.out.println("........................................................");

    GsonParser parser = new GsonParser();

    MskMetro newMskMetro = parser.parse();

    //System.out.println(newMskMetro.getLines().get(0).getLineName());
    System.out.println(newMskMetro.getStationsCountInLine());
    System.out.println(newMskMetro.getLines().size());


    //System.out.println(newMskMetro.getStationsCountInLine("1 Сокольническая линия"));



  }
}