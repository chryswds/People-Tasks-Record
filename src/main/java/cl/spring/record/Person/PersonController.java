package cl.spring.record.Person;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    // Add person
    @PostMapping("/add")
    public PersonModel addPerson(@RequestBody PersonModel person){
        return personService.createPerson(person);
    }

    // Show every person registered
    @GetMapping("/show")
    public List<PersonModel> listAll(){
        return personService.listAll();
    }

    // Search Person by ID
    @GetMapping("/show/{id}")
    public PersonModel showById(@PathVariable Long id){
        return personService.listById(id);
    }

    // Update Person
    @PutMapping("/update")
    public String updatePersonById(){
        return "Person updated";
    }

    // Delete Person
    @DeleteMapping("/delete")
    public String deletePersonById(){
        return "Person deleted";
    }


}
