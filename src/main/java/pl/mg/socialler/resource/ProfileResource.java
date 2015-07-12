package pl.mg.socialler.resource;

import pl.mg.socialler.model.Profile;
import pl.mg.socialler.service.ProfileService;
import pl.mg.socialler.service.ProfileServiceImpl;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by m on 2015-07-11.
 */

@Path("/profiles")
@Consumes("application/json")
@Produces("application/json")
public class ProfileResource {

    private ProfileService service = new ProfileServiceImpl();

    @GET
    public List<Profile> getProfiles() {
        return service.getAllProfiles();
    }

    @GET
    @Path("/{profileName}")
    public Profile getMessage(@PathParam("profileName") String profileName) {
        System.out.println("getProfile=" + profileName);
        return service.getProfile(profileName);
    }

    //create
    @POST
    public Profile postProfile(Profile profile) {
        return service.addProfile(profile);
    }

    //update
    @PUT
    @Path("/{profileId}")
    public Profile postMessage(@PathParam("profileId") String profileName, Profile profile) {
        profile.setProfileName(profileName);
        return service.updateProfile(profile);
    }


    @DELETE
    @Path("/{profileName}")
    public Profile deleteMessage(@PathParam("profileName") String profileName) {
        return service.removeProfile(profileName);
    }

}
