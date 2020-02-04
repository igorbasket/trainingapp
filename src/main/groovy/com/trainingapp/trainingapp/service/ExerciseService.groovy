package com.trainingapp.trainingapp.service

import com.trainingapp.trainingapp.repository.ExerciseRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Slf4j
@Service
class ExerciseService {

    @Autowired ExerciseRepository exerciseRepository

    void deleteExercise(String name) {
        def exerciseForDel = exerciseRepository
                .findByTrainingName(name)
        if(exerciseForDel){
            exerciseRepository.deleteAll(exerciseForDel)
        }

    }
}