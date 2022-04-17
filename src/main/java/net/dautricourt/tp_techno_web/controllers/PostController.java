package net.dautricourt.tp_techno_web.controllers;

import net.dautricourt.tp_techno_web.dto.PostDTO;
import net.dautricourt.tp_techno_web.entities.Author;
import net.dautricourt.tp_techno_web.entities.Post;
import net.dautricourt.tp_techno_web.exceptions.RecordNotFoundException;
import net.dautricourt.tp_techno_web.mappers.PostMapper;
import net.dautricourt.tp_techno_web.repositories.AuthorRepository;
import net.dautricourt.tp_techno_web.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by @HugoD <hg.dautricourt@gmail.com> on 14/04/2022
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("posts")
public class PostController{

    @Autowired
    PostRepository postRepository;

    @Autowired
    AuthorRepository authorRepository;


    PostMapper postMapper;

    @GetMapping("/")
    List<Post> getAllPosts(){
        return postRepository.getAllByBodyTextNot("").stream().toList();
    }

    @GetMapping("/{id}")
    Post getPost(@PathVariable Long id){
        return postRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Post id : '"+id+"' does not exist"));
    }

    //J'utilise un DTO car conseillé dans la doc de Sonar, pour plus de sécurité, non pas que cela serve grandement içi.
    @PostMapping
    Post createPost(@RequestBody PostDTO postDto){
        Author author = authorRepository.findById(postDto.author_id()).orElseThrow(() -> new RecordNotFoundException("Author id : '"+postDto.author_id()+"' does not exist"));
        System.out.println(postDto);
        return postRepository.save(postDto.createPost(author));
    }

    @DeleteMapping("/{id}")
    Long deletePost(@PathVariable Long id){
        return postRepository.deletePostById(id);
    }

    @PostMapping("/{id}")
    Post updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO){
        Post post = postRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Post id : '"+id+"' does not exist"));
        postMapper.updatePostFromDto(postDTO,post);
        return postRepository.save(post);
    }


}
