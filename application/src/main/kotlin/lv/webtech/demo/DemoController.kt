package lv.webtech.demo

import lv.webtech.demo.openapi.api.PetsApi
import lv.webtech.demo.openapi.model.Pet
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pets")
class DemoController: PetsApi {
    @GetMapping
    override fun listPets(limit: Int?): ResponseEntity<MutableList<Pet>> {
        val pet = Pet(1,"Fred")
        val pet2 = Pet(2,"Tom")
        val pets = mutableListOf(pet, pet2);
        return ResponseEntity.ok(pets);
    }
}