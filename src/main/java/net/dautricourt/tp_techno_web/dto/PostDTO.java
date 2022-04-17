package net.dautricourt.tp_techno_web.dto;

import net.dautricourt.tp_techno_web.entities.Author;
import net.dautricourt.tp_techno_web.entities.Post;
import javax.validation.constraints.Size;


public record PostDTO(
        @Size(min = 3, max = 100) String title,
        @Size(min = 3) String bodyText,
        Long author_id) {

    public Post createPost(Author author){
        return new Post(title, bodyText, author);
    }
}