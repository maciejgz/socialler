package pl.mg.socialler.resource;

import pl.mg.socialler.model.Message;
import pl.mg.socialler.service.MessageServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;

/**
 * Created by m on 2015-07-10.
 */
@Path(value = "/messages")
public class MessageResource {


    MessageServiceImpl service = new MessageServiceImpl();

    @GET
    @Produces("application/json")
    public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size) {
        if (year > 0) {
            return service.getAllMessagesForYear(year);
        } else if (start >= 0 && size > 0) {
            return service.getAllMessagesPaginated(start, size);
        }
        System.out.println(service.getAllMessages());
        return service.getAllMessages();

    }

    @GET
    @Path("/{messageId}")
    @Produces("application/json")
    public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
        System.out.println("getMessage=" + id);


        Message message = service.getMessage(id);
        String url = getSelfUrl(uriInfo, message);

        //hateoas implementation
        message.addLink(url, "self");
        message.addLink(getUrlForProfile(uriInfo, message), "profile");
        message.addLink(getUrlForComments(uriInfo,message),"comments");
        return service.getMessage(id);
    }

    private String getSelfUrl(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder().path(MessageResource.class)
                .path(Long.toString(message.getId()))
                .build()
                .toString();
    }

    private String getUrlForProfile(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder().path(ProfileResource.class)
                .path(message.getAuthor())
                .build()
                .toString();
    }

    private String getUrlForComments(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder().path(MessageResource.class)
                .path(MessageResource.class, "getCommentResource") //odwo³anie do zagnie¿d¿onego zasobu w funkcji
                .path(CommentResource.class)
                .resolveTemplate("messageId",message.getId()) //rozwik³anie wartoœci messageId w sk³adanym linku (trzeba podaæ nazwe atrybutu)
                .build()
                .toString();
    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postMessage(Message message) throws URISyntaxException {
        Message newMessage = service.addMessage(message);
        // return Response.created(new URI("/socialler/webapi/messages/" + newMessage.getId()))
        return Response.status(Response.Status.CREATED)
                .entity(message)
                .build();
    }

    @PUT
    @Path("/{messageId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Message postMessage(@PathParam("messageId") long messageId, Message message) {
        message.setId(messageId);
        return service.updateMessage(message);
    }

    @DELETE
    @Produces("application/json")
    @Path("/{id}")
    public Message deleteMessage(@PathParam("id") long id) {
        return service.removeMessage(id);
    }

    /**
     * Pobranie komentarzy
     *
     * @return
     */
    @Path("/{messageId}/comments/")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }

}
