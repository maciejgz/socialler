package pl.mg.socialler.service;

import pl.mg.socialler.database.Database;
import pl.mg.socialler.model.Comment;
import pl.mg.socialler.model.ErrorMessage;
import pl.mg.socialler.model.Message;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by m on 2015-07-11.
 */
public class CommentService {

    public Map<Long, Message> messages = Database.getMessages();

    public List<Comment> getAllComments(long messageId) {
        return new ArrayList<>(messages.get(messageId).getComments().values());
    }

    public Comment getComment(long messageId, long commentId) {
        //webApplicationException
        if(messages.get(messageId)==null){
            ErrorMessage message = new ErrorMessage();
            message.setErrorCode(404);
            message.setErrorMessage("messageId: " + messageId + " not found");
            message.setDocumentation("no doc");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(message).build();
            throw new WebApplicationException(response);
        }
        return messages.get(messageId).getComments().get(commentId);
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        System.out.println("addComment=" + comment.getMessage());
        comment.setId(comments.size() + 1);
        System.out.println("commentID=" + comment.getId());
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment removeComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }

}
