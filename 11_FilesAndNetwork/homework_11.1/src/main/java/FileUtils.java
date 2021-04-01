import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;

public class FileUtils {

  private static final int KB = 1024;
  private static final long MB = 1024 * 1024;
  private static final long GB = 1024 * 1024 * 1024;
  private static boolean kbWeight = false;
  private static boolean mbWeight = false;
  private static boolean gbWeight = false;


  public static double calculateFolderSize(String path) throws IOException {
    long size = Files.walk(new File(path).toPath())
        .map(f -> f.toFile())
        .filter(f -> f.isFile())
        .mapToLong(f -> f.length()).sum();

    if (size<KB){
      kbWeight = false;
      mbWeight = false;
      gbWeight = false;
    }
    if (size > KB && size < MB) {
      kbWeight = true;
      mbWeight = false;
      gbWeight = false;
      BigDecimal result = BigDecimal.valueOf(size).divide(BigDecimal.valueOf(KB))
          .setScale(2, RoundingMode.DOWN);
      return result.doubleValue();

    }
    if (size > MB && size < GB) {
      kbWeight = false;
      mbWeight = true;
      gbWeight = false;
      BigDecimal result = BigDecimal.valueOf(size).divide(BigDecimal.valueOf(MB))
          .setScale(2, RoundingMode.DOWN);
      return result.doubleValue();
    }
    if (size > GB) {
      kbWeight = false;
      mbWeight = false;
      gbWeight = true;
      BigDecimal result = BigDecimal.valueOf(size).divide(BigDecimal.valueOf(GB))
          .setScale(2, RoundingMode.DOWN);
      return result.doubleValue();
    }
    return size;
  }
  public static String sizeWeight(){
    if (kbWeight){return " KB";}
    if (mbWeight){return " MB";}
    if (gbWeight){return " GB";}
    return " byte";
  }
}
