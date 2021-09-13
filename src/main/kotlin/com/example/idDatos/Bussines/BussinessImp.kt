package com.example.idDatos.Bussines

import com.example.idDatos.Dao.PersonaRepository
import com.example.idDatos.Exception.ExceptionBusness
import com.example.idDatos.Exception.NotFoundException
import com.example.idDatos.Model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class BussinessImp : OIPersonaBussines {
    @Autowired
    val personaRepo: PersonaRepository? = null

    @Throws(ExceptionBusness::class)
    override fun List(): List<Persona> {
        try {
            return personaRepo!!.findAll()
        } catch (e: Exception) {
            throw ExceptionBusness(e.message)
        }
    }

    @Throws(ExceptionBusness::class, NotFoundException::class)

    override fun load(id: Long): Persona {
        val op: Optional<Persona>
        try {
            op = personaRepo!!.findById(id)
        } catch (e: Exception) {
            throw ExceptionBusness(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("no se encontro$id")
        }
        return op.get()
    }

    @Throws(ExceptionBusness::class)

    override fun save(persona: Persona): Persona {
        try {
            return personaRepo!!.save(persona)
        } catch (e: Exception) {
          throw  ExceptionBusness(e.message)
        }
    }

    override fun reemove(persona: Long) {
        val op: Optional<Persona>
        try {
            op = personaRepo!!.findById(persona)

        } catch (e:Exception) {

            throw ExceptionBusness(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("no se encontro$persona")
        } else{
            try {
                personaRepo!!.deleteById(persona)
            }catch (e:Exception){
                throw ExceptionBusness(e.message)
            }
        }
    }
}