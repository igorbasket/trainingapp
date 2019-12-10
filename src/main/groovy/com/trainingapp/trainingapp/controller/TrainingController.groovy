package com.trainingapp.trainingapp.controller

import com.trainingapp.trainingapp.domain.Training
import com.trainingapp.trainingapp.service.TrainingService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping('/api/training')
class TrainingController {

    @Autowired TrainingService trainingService
    @GetMapping('/userID_{id}')
    List<Training> getAllTrainnigByUser (@PathVariable('id') Integer id){
        trainingService
                        .trainingByUser(id)


    }

}
