import java.io.File;
import java.io.IOException;

public class FileUtils {

  public static void copyFolder(String sourceDirectory, String destinationDirectory)
      throws IOException {
    // TODO: write code copy content of sourceDirectory to destinationDirectory    File folder = new File(sourceDirName);
    org.apache.commons.io.FileUtils.copyDirectory(new File(sourceDirectory), new File(destinationDirectory));
  }
}
