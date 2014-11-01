package core;

import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.Collection;

public class lsTest {
    @Test
    public void show_return_folder(){
        File userDirectory = FileUtils.getUserDirectory();
        Collection<File> files = FileUtils.listFiles(userDirectory, null, false);
        Assert.assertTrue(files.size()>0);
    }
}
