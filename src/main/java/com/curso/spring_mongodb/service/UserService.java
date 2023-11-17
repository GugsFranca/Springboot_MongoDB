package com.curso.spring_mongodb.service;

import com.curso.spring_mongodb.domain.User;
import com.curso.spring_mongodb.repository.UserRepository;
import com.curso.spring_mongodb.service.exception.ObjectNotFindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
       Optional<User> opt = repository.findById(id);
       return opt.orElseThrow(() -> new ObjectNotFindException("Usuario não encontrado"));
    }
}
