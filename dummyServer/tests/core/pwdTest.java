package core;

import infra.IFileOperations;
import junit.framework.Assert;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;

/**
 * Created by twer on 14-11-2.
 */
public class pwdTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void should_return_pwd() {

        final IFileOperations fileOperations = context.mock(IFileOperations.class);
        context.checking(new Expectations() {{
            oneOf(fileOperations).getDirectory("");
            will(returnValue(new File("/usr/vagrant/InstallSave")));
        }});
        File directory = fileOperations.getDirectory("");
        Assert.assertTrue(directory.getPath() == "/usr/vagrant/InstallSave");
    }
}
