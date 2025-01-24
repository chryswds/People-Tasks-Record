package cl.spring.record.Person;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PersonController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Hello World!";
    }


    // Add person
    @PostMapping("/add")
    public String addPerson(){
        return "Person added";
    }

    // Show every person registered
    @GetMapping("/all")
    public String showAll(){
        return "All persons";
    }

    // Search Person by ID
    @GetMapping("/personbyid")
    public String showById(){
        return "Person by id";
    }

    // Update Person
    @PutMapping("/updatebyid")
    public String updatePersonById(){
        return "Person updated";
    }

    // Delete Person
    @DeleteMapping("/deletebyid")
    public String deletePersonById(){
        return "Person deleted";
    }


}
