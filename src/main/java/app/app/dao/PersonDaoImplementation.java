package app.app.dao;


import app.dao.repositories.PersonRepository;
import app.dao.Interfaces.PersonDao;
import app.dto.PersonDto;
import app.helpers.Helpers;
import app.model.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
@Getter
@Setter
public  class PersonDaoImplementation implements PersonDao{
    @Autowired
    PersonRepository personRepository;
    public boolean existsByDocument(PersonDto personDto) throws Exception {
		return personRepository.existsByDocument(Helpers.parse(personDto).getDocument());
	}
    public void createPerson(PersonDto personDto) throws Exception {
		Person person = Helpers.parse(personDto);
                personRepository.save(person);
                personDto.setiD(person.getID());
	}
    public void deletePerson(PersonDto personDto) throws Exception {
		Person person = Helpers.parse(personDto);
		personRepository.delete(person);
    }
    public PersonDto findByDocument(PersonDto personDto) throws Exception {
		Person person = personRepository.findByDocument(personDto.getDocument());
                return Helpers.parse(person);
	
    
}
    
        
    }
