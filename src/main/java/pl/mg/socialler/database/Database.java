package pl.mg.socialler.database;

import pl.mg.socialler.model.Comment;
import pl.mg.socialler.model.Message;
import pl.mg.socialler.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by m on 2015-07-10.
 */
public class Database {
    private static Map<Long, Message> messages = new HashMap<>();

    private static Map<String, Profile> profiles = new HashMap<>();


    public static Map<Long, Message> getMessages() {
        return messages;
    }


    static {
        System.out.println("messageServieImpl constructor");
        Message msg1 = new Message(1, "message1", "profile1");
        msg1.getComments().put(1L, new Comment("comment_1", 1L, "author1"));
        msg1.getComments().put(2L, new Comment("comment_2", 2L, "author2"));
        Database.getMessages().put(1L, msg1);
        Database.getMessages().put(2L, new Message(2, "message2", "profile2"));
        Database.getMessages().put(3L, new Message(3, "message3", "profile3"));
        Database.getMessages().put(4L, new Message(4, "message4", "profile4"));
        Database.getMessages().put(5L, new Message(5, "message5", "profile5"));
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
