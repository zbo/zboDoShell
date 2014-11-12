package webface;

import com.codahale.metrics.annotation.Timed;
import domain.Pwd;
import infra.FileOperations;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;

/**
 * Created by twer on 14-11-2.
 */
@Path("/dummyServer/pwd")
@Produces(MediaType.APPLICATION_JSON)
public class PwdResource {
    private final FileOperations fileOperations = new FileOperations();

    @GET
    @Timed
    public Pwd doGet() {
        Logger.getInstance(this.getClass()).info("pwd web call received");
        Pwd pwd = new Pwd();
        File userDirectory = fileOperations.getDirectory("");
        pwd.setPath(userDirectory.getPath());
        return pwd;
    }

}
