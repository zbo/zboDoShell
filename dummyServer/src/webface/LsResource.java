package webface;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import domain.Ls;
import infra.FileOperations;
import org.apache.log4j.Logger;

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
@Path("/dummyServer/ls")
@Produces(MediaType.APPLICATION_JSON)
public class LsResource {

    private final FileOperations fileOperations = new FileOperations();

    @GET
    @Timed
    public Ls doGet(@QueryParam("path") Optional<String> path) {
        Logger logger = Logger.getLogger(this.getClass());
        logger.info("ls web call received");
        Ls ls = new Ls();
        String inputPath = path.or("default");
        File userDirectory = fileOperations.getDirectory(inputPath);
        Collection<File> list = fileOperations.getFiles(userDirectory);
        ls.setPath(userDirectory.getPath());
        ls.setContent(list.toString());
        return ls;
    }

}
