package mvcproject.people.service;

import mvcproject.people.domain.Person;
import mvcproject.people.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository repo;

    @Autowired
    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public List<Person> listAll() {
        return repo.findAll();
    }

    @Transactional
    public void save(Person person) {
        repo.save(person);
    }

    public Person get(long id) {
        return repo.findById(id).get();
    }

    @Transactional
    public void delete(long id) {
        repo.deleteById(id);
    }
}
