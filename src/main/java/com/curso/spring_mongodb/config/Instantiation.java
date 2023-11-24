package com.curso.spring_mongodb.config;

import com.curso.spring_mongodb.domain.Post;
import com.curso.spring_mongodb.domain.User;
import com.curso.spring_mongodb.dto.AuthorDTO;
import com.curso.spring_mongodb.dto.CommentDTO;
import com.curso.spring_mongodb.repository.PostRepository;
import com.curso.spring_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yy");
        date.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, date.parse("31/03/15"), "Patil viagem", "Vou para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, date.parse("13/05/19"), "Bom dia!!!", "Acordei feliz", new AuthorDTO(maria));
        Post post3 = new Post(null, date.parse("23/12/01"), "Feliz aniversario", "Hoje é meu aniversario kkkk", new AuthorDTO(bob));

        CommentDTO c1 = new CommentDTO("Boa viagem mano", date.parse("02/04/15"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", date.parse("01/04/15"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um otimo dia", date.parse("31/03/15"), new AuthorDTO(maria));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);


        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
