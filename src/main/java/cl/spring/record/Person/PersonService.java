package cl.spring.record.Person;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }
    // Show all registered person
    public List<PersonModel> listAll(){
        return personRepository.findAll();
    }

    // Show Person by ID
    public PersonModel listById(Long id){
        Optional<PersonModel> personById = personRepository.findById(id);
        return personById.orElse(null);
    }

    // Add Person
    public PersonDTO createPerson(PersonDTO personDTO){
        PersonModel person = personMapper.map(personDTO);
        person = personRepository.save(person);
        return personMapper.map(person);
    }

    // Delete Person
    public void deletePersonById(Long id){
        personRepository.deleteById(id);
    }

    //Update Person
    public PersonModel updatePerson(Long id, PersonModel updatedPerson){
        if (personRepository.existsById(id)){
            updatedPerson.setId(id);
            return personRepository.save(updatedPerson);
        }
        return null;
    }



}

