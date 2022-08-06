package classes;

import classes.model.EmptyRequest;
import classes.model.Request;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Controller {

    @POST
    @Path("/post")
    public Uni<Request> post(Request request) {
        return Uni.createFrom().item(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Request> get() {
        return Uni.createFrom().item(new Request());
    }

    @POST
    public Uni<EmptyRequest> postEmpty(EmptyRequest request) {
        return Uni.createFrom().item(request);
    }
}
