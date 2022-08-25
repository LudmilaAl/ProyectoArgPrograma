
package com.portfolio.lma.Interface;

import com.portfolio.lma.Entity.Person;
import java.util.List;



public interface IPersonService {
    public List<Person> getPerson();
    
    public void savePerson(Person person);
    
    public void deletePerson(Long id);
    
    public Person findPerson(Long id);
}
