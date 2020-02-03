package com.trainingapp.trainingapp.repository

import com.trainingapp.trainingapp.domain.Exercise
import com.trainingapp.trainingapp.domain.Training
import com.trainingapp.trainingapp.model.ExerciseDTO
import org.springframework.data.jpa.repository.JpaRepository

interface ExerciseRepository extends JpaRepository<Exercise, Long>{


    List<Exercise> findByTrainingName(String s)

}