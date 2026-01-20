package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CreateUserRequest;
import com.example.demo.dto.UpdateUserRequest;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User createUser(CreateUserRequest request){
        User user = new User(null, request.getName(),request.getEmail());
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
            .orElseThrow(()-> new UserNotFoundException(id));
    }

    public void deleteById(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    public User updatUser(Long id,UpdateUserRequest request){
        User existing = userRepository.findById(id)
            .orElseThrow(()-> new UserNotFoundException(id));

        existing.setName(request.getName());
        existing.setEmail(request.getEmail());

        return userRepository.save(existing);
    }
}
