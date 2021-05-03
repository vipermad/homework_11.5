import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

  public static void main(String[] args) {
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
        //System.out.print(lineNumber + " ");//Номер линии
        //System.out.println(element.text());//Название линии
        Element line = root.selectFirst("div[data-depend-set=\"lines-" + lineNumber + "\"]");
        Elements stantions = line.select("a[data-metrost]").select("span[class=\"name\"]");
        for (Element stantion : stantions) {
          //System.out.println(stantion.text());//название станции
          lineNumberName.add(stantion.text());
        }
        mskMetro.setLine(lineNumberName);
      }
      String result = objectMapper.writeValueAsString(mskMetro);
      System.out.println(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}