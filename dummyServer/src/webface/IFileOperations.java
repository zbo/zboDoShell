package webface;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by twer on 14-11-2.
 */
public interface IFileOperations {
    Collection<File> getFiles(File userDirectory);

    File getDirectory(String inputPath);

    Collection<File> createFile(String inputPath, String inputName) throws IOException;
}
