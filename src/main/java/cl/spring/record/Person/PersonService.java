package cl.spring.record.Person;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    //Show all registered person
    public List<PersonModel> listAll(){
        return personRepository.findAll();
    }
}

