package pl.mg.socialler.model;

import java.util.Date;

/**
 * Created by m on 2015-07-11.
 */
public class Comment {

    private long id;


    private String message;
    private Date created;
    private String author;

    public Comment() {

    }

    public Comment(String message, long id, String author) {
        this.message = message;
        this.id = id;
        this.author = author;
    }


    public Comment(String message, String author) {
        this.message = message;
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", created=" + created +
                ", author='" + author + '\'' +
                '}';
    }
}
