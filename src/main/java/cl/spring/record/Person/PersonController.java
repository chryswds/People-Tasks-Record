package cl.spring.record.Person;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {


    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    // Add person
    @PostMapping("/add")
    public PersonDTO createPerson(@RequestBody PersonDTO person){
        return personService.createPerson(person);
    }

    // Show every person registered
    @GetMapping("/show")
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    // Search Person by ID
    @GetMapping("/show/{id}")
    public PersonDTO showById(@PathVariable Long id){
        return personService.listById(id);
    }

    // Update Person
    @PutMapping("/update/{id}")
    public PersonDTO updatePersonById(@PathVariable Long id, @RequestBody PersonDTO updatedPersonDTO){
        return personService.updatePerson(id, updatedPersonDTO);
    }

    // Delete Person
    @DeleteMapping("/delete/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personService.deletePersonById(id);
    }


}