package ua.net.ums.rest;

import ua.net.ums.model.User;
import ua.net.ums.service.UserService;

import javax.ejb.EJB;
import javax.ws.rs.*;

@Path("/user")
public class UserResource {

    @EJB
    private UserService userService;

    @GET
    @Path("/{userId}")
    @Produces("text/json")
    public User read(@PathParam("userId") Long userId) {
        return userService.findById(userId);
    }

    @PUT
    @Produces("text/json")
    @Consumes("text/json")
    public Long read(User user) {
        userService.create(user);
        return user.getId();
    }

    @GET
    @Path("/xml/{userId}")
    @Produces("text/xml")
    public User readAsXML(@PathParam("userId") Long userId) {
        return userService.findById(userId);
    }
}
