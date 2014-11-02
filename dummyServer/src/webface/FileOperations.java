package webface;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import static webface.CommonResource.HOME_VAGRANT_INSTALL_SAVE;

public class FileOperations implements IFileOperations {
    public FileOperations() {
    }

    @Override
    public Collection<File> getFiles(File userDirectory) {
        return FileUtils.listFiles(userDirectory, null, false);
    }

    @Override
    public File getDirectory(String inputPath) {
        File userDirectory = new File(CommonResource.HOME_VAGRANT_INSTALL_SAVE + inputPath);
        if (!userDirectory.exists()) {
            userDirectory.mkdir();
        }
        return userDirectory;
    }

    @Override
    public Collection<File> createFile(String inputPath, String inputName) throws IOException {
        File userDirectory = getDirectory(inputPath);
        File userFile = new File(HOME_VAGRANT_INSTALL_SAVE + inputPath + "/" + inputName);
        userFile.createNewFile();
        return FileUtils.listFiles(userDirectory, null, false);
    }
}