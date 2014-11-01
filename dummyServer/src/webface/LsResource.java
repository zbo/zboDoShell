package webface;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import domain.Ls;
import domain.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by twer on 14-11-1.
 */
@Path("/helloApp-world")
@Produces(MediaType.APPLICATION_JSON)
public class LsResource {
    @GET
    @Timed
    public Ls sayHello(@QueryParam("path") Optional<String> path) {
        return new Ls();
    }
}
