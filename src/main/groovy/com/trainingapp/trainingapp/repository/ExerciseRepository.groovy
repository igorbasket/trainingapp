package com.trainingapp.trainingapp.repository

import com.trainingapp.trainingapp.domain.Exercise
import org.springframework.data.jpa.repository.JpaRepository

interface ExerciseRepository extends JpaRepository<Exercise, Long>{

}