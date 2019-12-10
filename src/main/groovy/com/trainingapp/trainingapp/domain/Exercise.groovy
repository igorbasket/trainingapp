package com.trainingapp.trainingapp.domain


import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String name

    String description

    BigInteger time

    ExerciseType exerciseType

    @ManyToOne
    Training training




}
