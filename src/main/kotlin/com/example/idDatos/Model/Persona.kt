package com.example.idDatos.Model

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "persona")
class Persona ( val edad:Long=0, val nombre:String="", val datos:String=""
){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long=0
}