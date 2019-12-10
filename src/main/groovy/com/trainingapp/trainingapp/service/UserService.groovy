package com.trainingapp.trainingapp.service

import com.trainingapp.trainingapp.domain.User
import com.trainingapp.trainingapp.model.NewUserDTO
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

    Optional<UserDTO> addUser(NewUserDTO user){
        def val=userByEmail(user.email)
        if (val.isPresent()) {
            log.info "Optional is empty"
            return  Optional.empty()
        }
        val=userRepository.save(new User(name:user.name,
                                    email:user.email,
                                    password:user.password,
                                    age:user.age,
                                    weight:user.weight))

        Optional.of(new UserDTO(name:val.name,
                                email:val.email,
                                age:val.age,
                                weight:val.weight))
    }

}
