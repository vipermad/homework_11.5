import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

  public static void main(String[] args) throws IOException {
    Document doc = Jsoup.connect("https://lenta.ru").get();
    Elements linkImg = doc.select("img[src]");
    String attribute = "abs:src";
    Pattern pattern = Pattern.compile(".jpg");
    for (int i = 0; i < linkImg.size(); i++) {
      Matcher matcher = pattern.matcher(linkImg.get(i).attr(attribute));
      if (!matcher.find()){
        continue;
      }
      download(linkImg.get(i).attr(attribute));
    }
  }

  public static void download(String path) throws IOException {
    String url = path;
    File folder = new File("image");
    if (!folder.exists()) {
      folder.mkdir();
    }
    String fileName = "image/" + path.substring(path.lastIndexOf("/") + 1, path.length());
    try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(url).openStream());
    FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
      bufferedInputStream.transferTo(fileOutputStream);
    }
  }
}

