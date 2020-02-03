package com.trainingapp.trainingapp.service

import com.trainingapp.trainingapp.domain.Exercise
import com.trainingapp.trainingapp.domain.Training
import com.trainingapp.trainingapp.model.ExerciseDTO
import com.trainingapp.trainingapp.model.NewTrainingDTO
import com.trainingapp.trainingapp.model.TrainingDTO
import com.trainingapp.trainingapp.model.UserDTO
import com.trainingapp.trainingapp.repository.ExerciseRepository
import com.trainingapp.trainingapp.repository.TrainingRepository
import com.trainingapp.trainingapp.repository.UserRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.time.LocalDateTime

@Slf4j
@Service
class TrainingService {

    @Autowired TrainingRepository trainingRepository
    @Autowired UserRepository userRepository
    @Autowired ExerciseRepository exerciseRepository

    List<TrainingDTO> trainingByUser(String name) {
        trainingRepository
                .findByUserName(name)
                .collect{ new TrainingDTO(name:it.name, trainingDuration:it.trainingDuration)}
    }

    List<TrainingDTO> trainingByEmail(String email) {
        trainingRepository
                .findByUserEmail(email)
                .collect{ new TrainingDTO(name:it.name, trainingDuration:it.trainingDuration)}


    }

    Optional<NewTrainingDTO> addTraining (NewTrainingDTO newTraining) {
        def sum = 0
        newTraining
                .listExerciseDto
                .each {it -> sum += it.time}
        def val = trainingRepository.save(new Training(
                                                        name: newTraining.name,
                                                        data: LocalDateTime.now(),
                                                        trainingDuration: sum,
                                                        user: userRepository.findUserByEmail(newTraining.email)))
        val.exercise=newTraining
                .listExerciseDto
                .collect{it -> exerciseRepository.save(new Exercise(name: it.name,
                                                                            description: it.description,
                                                                            time: it.time,
                                                                            training: val))}


        Optional.of(newTraining)
    }

    List<ExerciseDTO> trainingByName(String name) {
        exerciseRepository
                .findByTrainingName(name)
                .collect{ new ExerciseDTO(name:it.name,
                        description: it.description,
                        time: it.time)}
    }

//    Optional<NewTrainingDTO> addOrCreateTraining(NewTrainingDTO newTrainingDTO) {
//        def val = trainingRepository.findByTrainingName(newTrainingDTO.name)
//        if (val.ifPresent()) {
//            def var = val.get()
//
//
//            log.info "Training not found"
//            addTraining(newTrainingDTO)
//        } // удаляем упражнения и записываем новые
//
//
//        Optional.of(newTrainingDTO)
//    }

    Optional<String> nameTraining(String name) {
        trainingRepository
                .findByName(name)
                .map{Optional.of(it.name)}
                .orElse(Optional.empty())

    }
}