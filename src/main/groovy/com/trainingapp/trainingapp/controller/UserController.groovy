package com.trainingapp.trainingapp.controller

import com.trainingapp.trainingapp.model.NewUserDTO
import com.trainingapp.trainingapp.model.UserDTO
import com.trainingapp.trainingapp.service.UserService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@Slf4j
@RestController
@RequestMapping('/api/user')
class UserController {

@Autowired UserService userService
    @GetMapping
    List<UserDTO> getAllUser(){
        userService.getUsers()
    }

    @GetMapping('/{email}')
    ResponseEntity<UserDTO> getUserByEmail(@PathVariable('email') String email){
        userService
                .userByEmail(email)
                .map{ResponseEntity.ok(it)}
                .orElse(ResponseEntity.notFound().build())
    }

    @GetMapping('/name/{name}')
    ResponseEntity<UserDTO> getOneUser(@PathVariable('name') String name){
        userService
                .userByName(name)
                .map{ResponseEntity.ok(it)}
                .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping('/registration')
    ResponseEntity<UserDTO> newUser(@RequestBody NewUserDTO user){
        userService
                .addUser(user)
                .map{ResponseEntity.ok(it)}
                .orElse(ResponseEntity.notFound().build())

    }

}
