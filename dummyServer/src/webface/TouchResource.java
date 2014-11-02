package webface;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import domain.Touch;
import infra.FileOperations;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by twer on 14-11-2.
 */
@Path("/dummyServer/touch")
@Produces(MediaType.APPLICATION_JSON)
public class TouchResource {
    private final FileOperations fileOperations = new FileOperations();

    @GET
    @Timed
    public Touch doGet(@QueryParam("path") Optional<String> path,
                       @QueryParam("name") Optional<String> name) throws IOException {
        Touch touch = new Touch();
        String inputPath = path.or("default");
        String inputName = name.or("");
        File userDirectory = fileOperations.getDirectory(inputPath);
        Collection<File> list = fileOperations.createFile(inputPath, inputName);
        touch.setPath(userDirectory.getPath());
        touch.setContent(list.toString());
        return touch;
    }

}
