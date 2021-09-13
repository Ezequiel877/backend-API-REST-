package com.example.idDatos.Web

import com.example.idDatos.Bussines.BussinessImp
import com.example.idDatos.Exception.ExceptionBusness
import com.example.idDatos.Exception.NotFoundException
import com.example.idDatos.Model.Persona
import com.example.idDatos.Utils.contans
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(contans.URL_BASE)
class PersonaRestController {
    @Autowired
    val personasBusness: BussinessImp? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Persona>> {
        return try {
            ResponseEntity(personasBusness!!.List(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idPersona: Long): ResponseEntity<Persona> {
        return try {
            ResponseEntity(personasBusness!!.load(idPersona), HttpStatus.OK)

        } catch (e: ExceptionBusness) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)

        }

    }

    @PostMapping("")
    fun insert(@RequestBody persona: Persona): ResponseEntity<Any> {
        return try {
            personasBusness!!.save(persona)
            val response = HttpHeaders()
            response.set("location", contans.URL_BASE + "/" + persona.id)
            ResponseEntity(response, HttpStatus.CREATED)
        } catch (e: ExceptionBusness) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)

        }
    }

    @PutMapping()
    fun update(@RequestBody persona: Persona): ResponseEntity<Any> {
        return try {
            personasBusness!!.save(persona)
            ResponseEntity(HttpStatus.OK)
        } catch (e: ExceptionBusness) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") IDpersona: Long): ResponseEntity<Any> {
        return try {
            personasBusness!!.reemove(IDpersona)
            ResponseEntity(HttpStatus.OK)
        } catch (e: ExceptionBusness) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)

        }
        catch (w:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}