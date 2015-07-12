package pl.mg.socialler.service;

import pl.mg.socialler.model.Profile;

import java.util.List;

/**
 * Created by m on 2015-07-11.
 */
public interface ProfileService {

    public List<Profile> getAllProfiles();

    public Profile getProfile(String profileName);

    public Profile addProfile(Profile profile);

    public Profile updateProfile(Profile profile);

    public Profile removeProfile(String profileName);
}
