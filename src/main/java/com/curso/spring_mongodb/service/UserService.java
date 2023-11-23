package com.curso.spring_mongodb.service;

import com.curso.spring_mongodb.domain.User;
import com.curso.spring_mongodb.dto.UserDTO;
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

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> opt = repository.findById(id);
        return opt.orElseThrow(() -> new ObjectNotFindException("Usuario não encontrado"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public User fromDTO(UserDTO obj) {
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
    public User update(User obj){
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
