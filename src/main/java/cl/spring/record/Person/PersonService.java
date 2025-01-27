package cl.spring.record.Person;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }
    // Show all registered person
    public List<PersonDTO> listAll(){
        List<PersonModel> person = personRepository.findAll();
        return person.stream()
                .map(personMapper::map)
                .collect(Collectors.toList());

    }

    // Show Person by ID
    public PersonDTO listById(Long id){
        Optional<PersonModel> personById = personRepository.findById(id);
        return personById.map(personMapper::map).orElse(null);
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
    public PersonDTO updatePerson(Long id, PersonDTO personDTO){
        Optional<PersonModel> personExist = personRepository.findById(id);
        if(personExist.isPresent()){
            PersonModel person = personMapper.map(personDTO);
            person.setId(id);
            PersonModel savedPerson = personRepository.save(person);
            return personMapper.map(savedPerson);
        }
        return null;
    }



}

