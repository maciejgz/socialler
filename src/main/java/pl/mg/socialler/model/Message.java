package pl.mg.socialler.model;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

/**
 * Created by m on 2015-07-10.
 */
@XmlRootElement
public class Message {


    @NotNull
    private long id;
    private String message;
    private Date created;
    private String author;


    //mapa komentarzy zostawianych pod wiadomoœci¹ przez u¿ytkowników
    private Map<Long, Comment> comments = new HashMap<>();


    private List<Link> links = new ArrayList<Link>();

    public Message() {

    }

    public Message(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.created = new Date();
        this.author = author;
    }

    public Message(String message, String author) {
        this.message = message;
        this.created = new Date();
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @XmlTransient
    public Map<Long, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", created=" + created +
                ", author='" + author + '\'' +
                ", comments=" + comments +
                ", links=" + links +
                '}';
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }


    public void addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        this.links.add(link);
    }

}
