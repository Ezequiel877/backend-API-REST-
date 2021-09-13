package com.example.idDatos

import com.example.idDatos.Dao.PersonaRepository
import com.example.idDatos.Model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.format.DateTimeFormatter

@SpringBootApplication
class IdDatosApplication : CommandLineRunner {
    @Autowired
    val personaRepository: PersonaRepository? = null


    override fun run(vararg args: String?) {
        val formater = DateTimeFormatter.ofPattern("dd/mm//nn")
        val persona = Persona(0, "ramon", "Valdez",)
        personaRepository?.save(persona)
    }

}
    fun main(args: Array<String>) {
        runApplication<IdDatosApplication>(*args)

}