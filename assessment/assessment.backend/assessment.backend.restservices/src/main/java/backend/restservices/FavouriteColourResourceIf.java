package backend.restservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Rest interface
 */

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/persons")
public interface FavouriteColourResourceIf {

    @GET
    Response getAllPeople ();

    @GET
    @Path("/{id}")
    Response getPersonById(@PathParam("id") int aId);

    @GET
    @Path("/color/{color}")
    Response getPeopleWhoLoveTheSameColor(@PathParam("color") String aColor);

}
