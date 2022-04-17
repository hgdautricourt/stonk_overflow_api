package net.dautricourt.tp_techno_web;

import net.dautricourt.tp_techno_web.entities.Author;
import net.dautricourt.tp_techno_web.repositories.AuthorRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Created by @HugoD <hg.dautricourt@gmail.com> on 07/04/2022
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorRepositoryTest {


        @Autowired
        private AuthorRepository authorRepository;

        @Test
        public void createAuthorAndFindIt() {
            Author author = new Author("Hugo","Dautricourt","hdautricourt@mail.com");
            authorRepository.save(author);
            Assertions.assertThat(authorRepository.findById(author.getId())).isInstanceOf(Optional.class);
            authorRepository.delete(author);
        }
}
