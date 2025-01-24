package cl.spring.record.Person;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    // Add person
    @PostMapping("/add")
    public String addPerson(){
        return "Person added";
    }

    // Show every person registered
    @GetMapping("/all")
    public List<PersonModel> listAll(){
        return "All persons";
    }

    // Search Person by ID
    @GetMapping("/person")
    public String showById(){
        return "Person by id";
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
