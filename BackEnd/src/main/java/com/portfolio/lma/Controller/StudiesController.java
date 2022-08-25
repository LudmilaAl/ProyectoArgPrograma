
package com.portfolio.lma.Controller;

import com.portfolio.lma.Dto.dtoStudies;
import com.portfolio.lma.Entity.Studies;
import com.portfolio.lma.Security.Controller.Mensaje;
import com.portfolio.lma.Service.StudiesService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/studies")
@CrossOrigin(origins = "https://frontendproyectoap.web.app")
public class StudiesController {
    
    @Autowired
    StudiesService studiesService;
    
     @GetMapping("/list")
    public ResponseEntity<List<Studies>> list(){
        List<Studies> list = studiesService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Studies> getById(@PathVariable("id") int id){
        if(!studiesService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.NOT_FOUND);
        Studies studies = studiesService.getOne(id).get();
        return new ResponseEntity(studies, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!studiesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.NOT_FOUND);
        }
        studiesService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoStudies dtostudies){      
        if(StringUtils.isBlank(dtostudies.getDegreeS()))
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(studiesService.existsByDegreeS(dtostudies.getDegreeS()))
            return new ResponseEntity(new Mensaje("Experiencia duplicada"), HttpStatus.BAD_REQUEST);
        
        Studies studies = new Studies(dtostudies.getDegreeS(), dtostudies.getDateS(), dtostudies.getInstitutionS());
        studiesService.save(studies);
        
        return new ResponseEntity(new Mensaje("Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoStudies dtoexp){
        
        if(!studiesService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.BAD_REQUEST);
        if(studiesService.existsByDegreeS(dtoexp.getDegreeS()) && studiesService.getByDegreeS(dtoexp.getDegreeS()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Experiencia duplicada"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getDegreeS()))
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        
        Studies studies = studiesService.getOne(id).get();
        studies.setDegreeS(dtoexp.getDegreeS());
        studies.setDateS(dtoexp.getDateS());
        studies.setInstitutionS(dtoexp.getInstitutionS());
        
        studiesService.save(studies);
        return new ResponseEntity(new Mensaje("Actualizada"), HttpStatus.OK);
             
    }
    
}
