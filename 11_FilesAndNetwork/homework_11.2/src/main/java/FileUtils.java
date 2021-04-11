import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils{

  public static void copyFolder(String sourceDirectory, String destinationDirectory)
      throws IOException {
    Path sourcePath = Paths.get(sourceDirectory);
    Path destPath = Paths.get(destinationDirectory);
    Files.walkFileTree(sourcePath, new MySimpleFileVisitor(sourcePath, destPath) {
    });
  }
}

class MySimpleFileVisitor extends SimpleFileVisitor<Path> {
  Path src;
  Path dest;

  public MySimpleFileVisitor(Path sourcePath, Path destPath) {
    this.src = sourcePath;
    this.dest = destPath;
  }

  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
      throws IOException {
    try {
      Path targetPath = dest.resolve(src.relativize(dir));
      if (!targetPath.toFile().exists()) {
        Files.createDirectory(targetPath);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    try {
      Path targetPath = src.resolve(src.relativize(file));
      Files.copy(file, targetPath, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return FileVisitResult.CONTINUE;
  }
}