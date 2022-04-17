package net.dautricourt.tp_techno_web.repositories;

import net.dautricourt.tp_techno_web.entities.Author;
import net.dautricourt.tp_techno_web.entities.Post;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by @HugoD <hg.dautricourt@gmail.com> on 14/04/2022
 */
public interface PostRepository extends CrudRepository<Post,Long> {
    @Transactional
    public Long deletePostById(Long id);
    public List<Post> getAllByAuthor(Author author);
    public List<Post> getAllByBodyTextNot(@Size(min = 3) String bodyText);
}
