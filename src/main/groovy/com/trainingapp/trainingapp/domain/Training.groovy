package com.trainingapp.trainingapp.domain

import javax.persistence.*
import java.time.LocalDateTime

@Entity
class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String name

    LocalDateTime data

    BigInteger trainingDuration

    @ManyToOne
    User user

    @OneToMany(fetch = FetchType.LAZY, mappedBy = 'training')
    List<Exercise> exercise = []


}
