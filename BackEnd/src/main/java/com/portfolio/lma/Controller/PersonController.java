
package com.portfolio.lma.Controller;

import com.portfolio.lma.Entity.Person;
import com.portfolio.lma.Interface.IPersonService;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "https://frontendproyectoap.web.app")
public class PersonController {
    @Autowired IPersonService ipersonService;
    
    @GetMapping("/person/get")
    public List<Person> getPerson(){
        return ipersonService.getPerson();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/person/create")
    public String createPerson(@RequestBody Person person){
        ipersonService.savePerson(person);
        return "The user was created successfully";
    }
     
    @PreAuthorize("hasRole('ADMIN')")   
    @DeleteMapping("/person/delete/{id}")
    public String deletePerson (@PathVariable Long id){
        ipersonService.deletePerson(id);
        return "The user was deleted successfully";
    }
      
    @PreAuthorize("hasRole('ADMIN')")  
    @PutMapping("/person/edit/{id}")
    public Person editPerson(@PathVariable Long id, 
                             @RequestParam("name") String newName,
                             @RequestParam("surname") String newSurname,
                             @RequestParam("perfil") String newPerfil){
        Person person = ipersonService.findPerson(id);
        person.setName(newName);
        person.setSurname(newSurname);
        person.setPerfil(newPerfil);
        
        ipersonService.savePerson(person);
        return person;
    }
    
    @GetMapping("/person/get/perfil")
    public Person findPerson(){
        return ipersonService.findPerson((long)1);
    }
}
