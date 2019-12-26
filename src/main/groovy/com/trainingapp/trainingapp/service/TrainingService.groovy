package com.trainingapp.trainingapp.service

import com.trainingapp.trainingapp.domain.Training
import com.trainingapp.trainingapp.model.TrainingDTO
import com.trainingapp.trainingapp.model.UserDTO
import com.trainingapp.trainingapp.repository.TrainingRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Slf4j
@Service
class TrainingService {

    @Autowired TrainingRepository trainingRepository

    List<TrainingDTO> trainingByUser(String name) {
        trainingRepository
                .findByUserName(name)
                .collect{ new TrainingDTO(name:it.name, trainingDuration:it.trainingDuration)}
    }
}
