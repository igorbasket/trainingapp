package com.trainingapp.trainingapp.controller

import com.trainingapp.trainingapp.domain.Training
import com.trainingapp.trainingapp.model.ExerciseDTO
import com.trainingapp.trainingapp.model.NewTrainingDTO
import com.trainingapp.trainingapp.model.NewUserDTO
import com.trainingapp.trainingapp.model.TrainingDTO
import com.trainingapp.trainingapp.model.UserDTO
import com.trainingapp.trainingapp.service.TrainingService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping('/api/training')
class TrainingController {

    @Autowired TrainingService trainingService
    @GetMapping('/user/{name}')
    List<TrainingDTO> getTrainingsByUser (@PathVariable('name') String name){
        trainingService
                .trainingByUser(name)
    }

    @GetMapping('/email/{email}/')
    List<TrainingDTO> getTrainingsByEmail (@PathVariable('email') String email){
        trainingService
                .trainingByEmail(email)
    }

    @GetMapping('/{nameTraining}/')
    List<ExerciseDTO> getTrainingByName (@PathVariable('nameTraining') String name){
        trainingService
                .trainingByName(name)
    }
//
//    @GetMapping('/searchName/{nameTraining}/')
//    String getTrainingName (@PathVariable('nameTraining') String name){
//        trainingService
//                .nameTraining(name)
//    }

    @PostMapping('/newTraining')
    ResponseEntity<NewTrainingDTO> newTraining(@RequestBody NewTrainingDTO training){
        trainingService
                .addTraining(training)
                .map{ResponseEntity.ok(it)}
                .orElse(ResponseEntity.notFound().build())

    }
    @PutMapping('/updateTraining/')
    ResponseEntity<NewTrainingDTO> createOrUpdTraining(@RequestBody NewTrainingDTO training){
        trainingService
                .updOrCreateTraining(training)
                .map{ResponseEntity.ok(it)}
                .orElse(ResponseEntity.notFound().build())
    }


//    @PutMapping("{id}")
//    def changeMess(@PathVariable String id,@RequestBody String str){
//        def value = mess.find{it.id == id}
//        if (value){
//            mess.remove(value)
//        }
//        mess.add([id: id, text: str])
//        mess.sort{it.id}
//    }
}