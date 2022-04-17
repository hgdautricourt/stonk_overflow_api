package net.dautricourt.tp_techno_web.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by @HugoD <hg.dautricourt@gmail.com> on 14/04/2022
 */

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 100)
    private String title;

    @Size(min = 3)
    private String bodyText;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;


    public Post(String title, String bodyText, Author author) {
        this.title = title;
        this.bodyText = bodyText;
        this.author = author;
    }

    public Post() {

    }

    public Long getId() {return id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
