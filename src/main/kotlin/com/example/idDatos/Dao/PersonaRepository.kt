package com.example.idDatos.Dao

import com.example.idDatos.Model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepository:JpaRepository<Persona, Long> {
}