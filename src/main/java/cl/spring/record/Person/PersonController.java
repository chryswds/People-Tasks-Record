package cl.spring.record.Person;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Creates a new person", description = "This route creates a new person and inserts it into the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Person created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
    })
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO person){
        PersonDTO newPerson = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Person created\n" + "Name :" + newPerson.getName() + "\nID :" + newPerson.getId());
    }

    // Show every person registered
    @GetMapping("/show")
    @Operation(summary = "List all persons", description = "This route lists all persons registered in the database")
    public ResponseEntity<List<PersonDTO>> listAll(){
        List<PersonDTO> persons = personService.listAll();
        return ResponseEntity.ok(persons);
    }

    // Search Person by ID
    @GetMapping("/show/{id}")
    @Operation(summary = "Search person by ID", description = "This route searches for a person by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person found"),
            @ApiResponse(responseCode = "404", description = "Person not found"),
    })
    public ResponseEntity<?> showById(@PathVariable Long id){
            PersonDTO person = personService.listById(id);
            if (person != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(person);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Person with ID: " + id + " not found");
            }

    }

    // Update Person
    @PutMapping("/update/{id}")
    @Operation(summary = "Update person by ID", description = "This route updates a person by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person updated"),
            @ApiResponse(responseCode = "404", description = "Person not found"),
    })
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
    @Operation(summary = "Delete person by ID", description = "This route deletes a person by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person deleted"),
            @ApiResponse(responseCode = "404", description = "Person not found"),
    })
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