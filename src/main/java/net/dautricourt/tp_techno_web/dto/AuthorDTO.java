package net.dautricourt.tp_techno_web.dto;

import net.dautricourt.tp_techno_web.entities.Author;


/**
 * Created by @HugoD <hg.dautricourt@gmail.com> on 14/04/2022
 * J'utilise un DTO car conseillé dans la doc de Sonar, pour plus de sécurité, non pas que cela serve grandement içi.
 */
public record AuthorDTO( String firstName,
                        String lastName,
                        String email) {


    public Author createAuthor() {
        return new Author(firstName,lastName,email);
    }
}

