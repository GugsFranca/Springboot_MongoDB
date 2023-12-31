package com.curso.spring_mongodb.service;

import com.curso.spring_mongodb.domain.Post;
import com.curso.spring_mongodb.repository.PostRepository;
import com.curso.spring_mongodb.service.exception.ObjectNotFindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> opt = repository.findById(id);
        return opt.orElseThrow(() -> new ObjectNotFindException("Usuario não encontrado"));
    }

    public List<Post> findByTitle(String text){
//        return repository.findByTitleContainingIgnoreCase(text);
        return repository.searchTitle(text);

    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }


}
