package cl.spring.record.Person;

import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonModel map(PersonDTO personDTO) {
        PersonModel personModel = new PersonModel();
        personModel.setId(personDTO.getId());
        personModel.setName(personDTO.getName());
        personModel.setEmail(personDTO.getEmail());
        personModel.setImgUrl(personDTO.getImgUrl());
        personModel.setAge(personDTO.getAge());
        personModel.setSurname(personDTO.getSurname());
        personModel.setTasks(personDTO.getTasks());
        return personModel;
    }

    public PersonDTO map(PersonModel personModel) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(personModel.getId());
        personDTO.setName(personModel.getName());
        personDTO.setEmail(personModel.getEmail());
        personDTO.setImgUrl(personModel.getImgUrl());
        personDTO.setAge(personModel.getAge());
        personDTO.setSurname(personModel.getSurname());
        personDTO.setTasks(personModel.getTasks());
        return personDTO;
    }
}
