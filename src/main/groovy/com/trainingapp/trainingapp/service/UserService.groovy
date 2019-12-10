package com.trainingapp.trainingapp.service

import com.trainingapp.trainingapp.model.UserDTO
import com.trainingapp.trainingapp.repository.UserRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
@Slf4j
class UserService {

@Autowired UserRepository userRepository

     List<UserDTO> getUsers() {
        userRepository
                .findAll()
                .collect{it-> new UserDTO(name:it.name, email:it.email, age:it.age, weight:it.weight)}
    }


    Optional<UserDTO> userByEmail(String email) {
        userRepository
                    .findByEmail(email)
                    .map {Optional.of(new UserDTO(name:it.name, email:it.email, age:it.age, weight:it.weight))}
                    .orElse(Optional.empty())
    }

    Optional<UserDTO> userByName(String name) {
        userRepository
                    .findByName(name)
                    .map{Optional.of(new UserDTO(name:it.name, email:it.email, age:it.age, weight:it.weight))}
                    .orElse(Optional.empty())
    }
}
