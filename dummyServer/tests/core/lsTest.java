package core;

import infra.FileOperations;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class lsTest {
    @Mock
    FileOperations fileOperation;
    @Mock
    File userDirectory;// = new File("/usr/vagrant/InstallSave/zbo");
    @InjectMocks
    Collection<File> files=new ArrayList<File>();

    @Before
    public void setup() {
        initMocks(this);
        File file1=new File("/usr/vagrant/InstallSave/zbo/bob1.txt");
        File file2=new File("/usr/vagrant/InstallSave/zbo/bob2.txt");
        files.add(file1);
        files.add(file2);
        when(fileOperation.getDirectory("zbo")).thenReturn(userDirectory);
        when(fileOperation.getFiles(userDirectory)).thenReturn(files);
    }

    @Test
    public void show_return_folder() {
        File directory = fileOperation.getDirectory("zbo");
        Collection<File> files = fileOperation.getFiles(directory);
        Assert.assertTrue(files.size() > 0);
    }
}
