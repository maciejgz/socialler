package pl.mg.socialler.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by m on 2015-07-10.
 */
@XmlRootElement
public class Profile {

    private long id;
    private String profileName;
    private String firstName;
    private String lastName;
    private Date created;

    public Profile() {

    }

    public Profile(String lastName, long id, String profileName, String firstName) {
        this.lastName = lastName;
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
