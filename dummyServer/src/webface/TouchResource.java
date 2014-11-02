package webface;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import domain.Ls;
import domain.Touch;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFileFilter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by twer on 14-11-2.
 */
@Path("/dummyServer/touch")
@Produces(MediaType.APPLICATION_JSON)
public class TouchResource implements CommonResource{
    @GET
    @Timed
    public Touch doGet(@QueryParam("path") Optional<String> path,
                    @QueryParam("name") Optional<String> name) throws IOException {
        Touch touch = new Touch();
        String inputPath = path.or("default");
        String inputName = name.or("");
        File userDirectory = new File(HOME_VAGRANT_INSTALL_SAVE+inputPath);
        if(!userDirectory.exists()){
            userDirectory.mkdir();
        }
        File userFile = new File(HOME_VAGRANT_INSTALL_SAVE+inputPath+"/"+inputName);
        userFile.createNewFile();
        Collection<File> list = FileUtils.listFiles(userDirectory, null, false);
        touch.setPath(userDirectory.getPath());
        touch.setContent(list.toString());
        return touch;
    }
}
