package pl.mg.socialler.service;

import pl.mg.socialler.database.Database;
import pl.mg.socialler.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by m on 2015-07-11.
 */
public class ProfileServiceImpl implements ProfileService {

    private Map<String, Profile> profiles = Database.getProfiles();

    public ProfileServiceImpl() {
        profiles.put("profile_1_last_name", new Profile("profile_1", 1L, "profile_1", "profile_1_first_name"));
        profiles.put("profile_2_last_name", new Profile("profile_2", 2L, "profile_2", "profile_2_first_name"));

    }

    @Override
    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    @Override
    public Profile getProfile(String profileName) {
        return profiles.get(profileName);
    }

    @Override
    public Profile addProfile(Profile profile) {
        long newId = profiles.size() + 1;
        profile.setId(newId);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    @Override
    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }
}
