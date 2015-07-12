package pl.mg.socialler.service;

import pl.mg.socialler.model.Message;

import java.util.List;

/**
 * Created by m on 2015-07-10.
 */
public interface MessageService {

    public List<Message> getAllMessages();

    List<Message> getAllMessagesForYear(int year);

    List<Message> getAllMessagesPaginated(int start, int size);

    public Message getMessage(long id);
    public Message addMessage(Message msg);
    public Message updateMessage(Message msg);
    public Message removeMessage(long id);
}
