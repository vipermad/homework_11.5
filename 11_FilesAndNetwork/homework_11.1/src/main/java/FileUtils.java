import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.text.DecimalFormat;

public class FileUtils {


  public static long calculateFolderSize(String path) throws NotDirectoryException {
    long size = 0;
    File f = new File(path);
    for (File file : f.listFiles()) {
      if (file.isFile()) {
        size += file.length();
      } else {
        size += calculateFolderSize(file.getAbsolutePath());
      }
    }
    return size;
  }

  public static double folderSize(String path) throws IOException {
    return Files.walk(new File(path).toPath())
        .map(f -> f.toFile())
        .filter(f -> f.isFile())
        .mapToLong(f -> f.length()).sum();
  }

  public static String nameSize(long size) {
    if (size <= 0) {
      return "0";
    }
    final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
    int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
    return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups))
        + " " + units[digitGroups];
  }
}