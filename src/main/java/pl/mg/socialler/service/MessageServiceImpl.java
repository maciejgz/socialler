package pl.mg.socialler.service;

import pl.mg.socialler.database.Database;
import pl.mg.socialler.exception.DataNotFoundException;
import pl.mg.socialler.model.Comment;
import pl.mg.socialler.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by m on 2015-07-10.
 */
public class MessageServiceImpl implements MessageService {

    private Map<Long, Message> messages = Database.getMessages();

    public MessageServiceImpl() {

    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(Database.getMessages().values());
    }

    @Override
    public List<Message> getAllMessagesForYear(int year) {
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Message message : messages.values()) {
            cal.setTime(message.getCreated());
            if (cal.get(Calendar.YEAR) == year) {
                messagesForYear.add(message);
            }
        }
        return messagesForYear;
    }

    @Override
    public List<Message> getAllMessagesPaginated(int start, int size) {
        ArrayList<Message> messagespaginated = new ArrayList<>(messages.values());
        if (start + size > messagespaginated.size()) {
            return new ArrayList<Message>();
        }

        return messagespaginated.subList(start, start + size);
    }


    @Override
    public Message getMessage(long id) {
        Message message = Database.getMessages().get(id);
        if(message==null){
            throw new DataNotFoundException();
        }
        return message;
    }

    @Override
    public Message addMessage(Message msg) {
        msg.setId(Database.getMessages().size() + 1);
        Database.getMessages().put(msg.getId(), msg);
        return msg;
    }

    @Override
    public Message updateMessage(Message msg) {
        System.out.println(msg);
        Database.getMessages().put(msg.getId(), msg);
        return msg;
    }

    @Override
    public Message removeMessage(long id) {
        return Database.getMessages().remove(id);
    }

}
