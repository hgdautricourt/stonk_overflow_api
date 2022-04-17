package net.dautricourt.tp_techno_web.repositories;

import net.dautricourt.tp_techno_web.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Size;

/**
 * Created by @HugoD <hg.dautricourt@gmail.com> on 04/04/2022
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author,Long>{
    Author findAuthorByEmail(String email);
    Boolean existsAuthorByEmail(String email);
    Author deleteAuthorById(Long id);
    Author getAuthorByFirstNameAndLastName(@Size(min = 3, max = 30) String firstName, @Size(min = 3, max = 30) String lastName);
}
