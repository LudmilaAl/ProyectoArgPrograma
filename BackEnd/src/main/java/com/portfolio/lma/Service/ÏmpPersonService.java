
package com.portfolio.lma.Service;

import com.portfolio.lma.Entity.Person;
import com.portfolio.lma.Interface.IPersonService;
import com.portfolio.lma.Repository.IPersonRepositort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ÏmpPersonService implements IPersonService{
    @Autowired IPersonRepositort ipersonRepository;
    
    
    @Override
    public List<Person> getPerson() {
       List<Person> person = ipersonRepository.findAll();
       return person;
    }

    @Override
    public void savePerson(Person person) {
       ipersonRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        ipersonRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        Person person = ipersonRepository.findById(id).orElse(null);
        return person;
    }
    
}
