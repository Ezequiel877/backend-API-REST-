package com.example.idDatos.Bussines

import com.example.idDatos.Model.Persona

interface OIPersonaBussines {
    fun List(): List<Persona>
    fun load(id: Long): Persona
    fun save(persona:Persona):Persona
    fun reemove(persona:Long)
}