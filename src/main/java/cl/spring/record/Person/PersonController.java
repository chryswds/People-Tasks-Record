package cl.spring.record.Person;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO person){
        PersonDTO newPerson = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Person created\n" + "Name :" + newPerson.getName() + "\nID :" + newPerson.getId());
    }

    // Show every person registered
    @GetMapping("/show")
    public ResponseEntity<String> listAll(){
        List<PersonDTO> persons = personService.listAll();
        return ResponseEntity.ok(persons.toString());
    }

    // Search Person by ID
    @GetMapping("/show/{id}")
    public ResponseEntity<String> showById(@PathVariable Long id){
            PersonDTO person = personService.listById(id);
            if (person != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(person.toString());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Person with ID: " + id + " not found");
            }

    }

    // Update Person
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePersonById(@PathVariable Long id, @RequestBody PersonDTO updatedPersonDTO){
        if (personService.listById(id) != null){
            PersonDTO personUpdate = personService.updatePerson(id, updatedPersonDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Person with ID: " + id + " updated\n" + "Name: " + personUpdate.getName());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Person with ID: " + id + " not found");
    }

    // Delete Person
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
        if (personService.listById(id) != null) {
            personService.deletePersonById(id);
            return ResponseEntity.ok()
                    .body("Person with ID: " + id + " deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Person with ID: " + id + " not found");

    }


}