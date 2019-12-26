package com.trainingapp.trainingapp.repository

import com.trainingapp.trainingapp.domain.Training
import org.springframework.data.jpa.repository.JpaRepository

interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findByUserName(String s)
}