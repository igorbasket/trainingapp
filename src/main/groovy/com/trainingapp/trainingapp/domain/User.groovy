package com.trainingapp.trainingapp.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    String name

    String email

    String password

    @OneToMany(fetch = FetchType.LAZY, mappedBy = 'user')
    List<Training> training = []

    Integer age

    BigDecimal weight

}
