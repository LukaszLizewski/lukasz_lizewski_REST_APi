package com.crud.smog.service;

import com.crud.smog.domain.UserEntity;
import com.crud.smog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbUserService {
    @Autowired
    private UserRepository userRepository;
    public UserEntity saveUserEntity (final UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
    public Optional<UserEntity> getUser (final Long id) {
        return userRepository.findById(id);
    }
    public List<UserEntity> getListOfUsers () {
        return userRepository.findAll();
    }
    public void deleteUser (final Long id) {
        userRepository.deleteById(id);
    }
}
