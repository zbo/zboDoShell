package webface;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import domain.Ls;
import org.apache.commons.io.FileUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.Collection;

/**
 * Created by twer on 14-11-1.
 */
@Path("/dummyServer")
@Produces(MediaType.APPLICATION_JSON)
public class LsResource {

    public static final String HOME_VAGRANT_INSTALL_SAVE = "/home/vagrant/InstallSave/";

    @GET
    @Timed
    public Ls sayHello(@QueryParam("path") Optional<String> path) {
        Ls ls = new Ls();
        String inputPath = path.or("default");
        File userDirectory = new File(HOME_VAGRANT_INSTALL_SAVE+inputPath);
        if(!userDirectory.exists()){
            userDirectory.mkdir();
        }
        Collection<File> list = FileUtils.listFiles(userDirectory, null, false);
        ls.setPath(userDirectory.getPath());
        ls.setContent(list.toString());
        return ls;
    }
}
