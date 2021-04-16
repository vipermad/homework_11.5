import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

  public static void main(String[] args) throws IOException {
    Document doc = Jsoup.connect("https://lenta.ru").get();
    Elements linkImg = doc.select("img[src]");
    String attribute = "abs:src";

    for (int i = 0; i < linkImg.size(); i++) {
      download(linkImg.get(i).attr(attribute));
    }
  }

  public static void download(String path) {
    String url = path;
    String fileName = "image/" + path.substring(path.lastIndexOf("/") + 1, path.length());
    FileOutputStream fileOutputStream = null;
    BufferedInputStream bufferedInputStream = null;
    try {
      bufferedInputStream = new BufferedInputStream(new URL(url).openStream());
      fileOutputStream = new FileOutputStream(fileName);
      byte data[] = new byte[1024];
      int count;
      while ((count = bufferedInputStream.read(data, 0, 1024)) != -1) {
        fileOutputStream.write(data, 0, count);
        fileOutputStream.flush();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        bufferedInputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          fileOutputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
