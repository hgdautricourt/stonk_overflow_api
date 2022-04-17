package net.dautricourt.tp_techno_web.controllers;

import net.dautricourt.tp_techno_web.dto.AuthorDTO;
import net.dautricourt.tp_techno_web.entities.Author;
import net.dautricourt.tp_techno_web.entities.Post;
import net.dautricourt.tp_techno_web.exceptions.RecordAlreadyExistException;
import net.dautricourt.tp_techno_web.exceptions.RecordNotFoundException;
import net.dautricourt.tp_techno_web.mappers.AuthorMapper;
import net.dautricourt.tp_techno_web.repositories.AuthorRepository;
import net.dautricourt.tp_techno_web.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by @HugoD <hg.dautricourt@gmail.com> on 07/04/2022
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("authors")
public class AuthorController{

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    AuthorMapper authorMapper;


    @GetMapping("/{id}")
    Author getAuthor(@PathVariable Long id){
            return  authorRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Author id : '"+id+"' does not exist"));
    }

    @GetMapping("/email/{email}")
    Author getAuthorByEmail(@PathVariable String email){
        return authorRepository.findAuthorByEmail(email);
    }

    @GetMapping("/{id}/posts")
    List<Post> getAllPostFromAuthor(@PathVariable Long id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Author id : '"+id+"' does not exist"));
        return postRepository.getAllByAuthor(author);
    }

    @PostMapping
    Author createAuthor(@RequestBody AuthorDTO authorDTO){
        if (Boolean.TRUE.equals(authorRepository.existsAuthorByEmail(authorDTO.email()))) throw new RecordAlreadyExistException("An author with email "+authorDTO.email()+" already exist");
        return authorRepository.save(authorDTO.createAuthor());
    }

    @DeleteMapping("/{id}")
    Author deleteAuthor(@PathVariable Long id){
        return authorRepository.deleteAuthorById(id);
    }

    @PostMapping("/{id}")
    Author updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO){
        Author author = authorRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Author id : '"+id+"' does not exist"));
        authorMapper.updateAuthorFromDto(authorDTO,author);
        return authorRepository.save(author);
    }

}


