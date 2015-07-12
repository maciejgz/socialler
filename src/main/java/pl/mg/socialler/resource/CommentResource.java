package pl.mg.socialler.resource;

import pl.mg.socialler.model.Comment;
import pl.mg.socialler.service.CommentService;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by m on 2015-07-11.
 */
@Path("/")
@Consumes("application/json")
@Produces("application/json")
public class CommentResource {

    CommentService commentService = new CommentService();


    @GET
    public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
        return commentService.getAllComments(messageId);
    }


    @GET
    @Path("/{commentId}")
    public Comment getComment(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId) {


        return commentService.getComment(messageId, commentId);
    }

    @POST
    public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
        return commentService.addComment(messageId,comment);
    }

    @PUT
    public Comment updateComment(@PathParam("messageId") long messageId, Comment comment) {
        return commentService.updateComment(messageId, comment);
    }


    @DELETE
    @Path("/commentId")
    public Comment deleteComment(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId) {
        return commentService.removeComment(messageId, commentId);
    }


}
