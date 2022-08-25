package com.portfolio.lma.Controller;


import com.portfolio.lma.Dto.dtoExperience;
import com.portfolio.lma.Entity.WorkExperience;
import com.portfolio.lma.Security.Controller.Mensaje;
import com.portfolio.lma.Service.WExperienceService;
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
@RequestMapping("/workexp")
@CrossOrigin(origins = "https://frontendproyectoap.web.app")
public class ExperienceController {
    @Autowired
    WExperienceService wExperienceService;
    
    @GetMapping("/list")
    public ResponseEntity<List<WorkExperience>> list(){
        List<WorkExperience> list = wExperienceService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<WorkExperience> getById(@PathVariable("id") int id){
        if(!wExperienceService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.NOT_FOUND);
        WorkExperience workExperience = wExperienceService.getOne(id).get();
        return new ResponseEntity(workExperience, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!wExperienceService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.NOT_FOUND);
        }
        wExperienceService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperience dtoexp){      
        if(StringUtils.isBlank(dtoexp.getNameExp()))
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(wExperienceService.existsByNameExp(dtoexp.getNameExp()))
            return new ResponseEntity(new Mensaje("Experiencia duplicada"), HttpStatus.BAD_REQUEST);
        
        WorkExperience workExperience = new WorkExperience(dtoexp.getNameExp(), dtoexp.getDescriptionExp(), dtoexp.getDateExp());
        wExperienceService.save(workExperience);
        
        return new ResponseEntity(new Mensaje("Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperience dtoexp){
        
        if(!wExperienceService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.BAD_REQUEST);
        if(wExperienceService.existsByNameExp(dtoexp.getNameExp()) && wExperienceService.getByNameExp(dtoexp.getNameExp()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Experiencia duplicada"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getNameExp()))
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        
        WorkExperience workExperience = wExperienceService.getOne(id).get();
        workExperience.setNameExp(dtoexp.getNameExp());
        workExperience.setDescriptionExp((dtoexp.getDescriptionExp()));
        workExperience.setDateExp((dtoexp.getDateExp()));
        
        wExperienceService.save(workExperience);
        return new ResponseEntity(new Mensaje("Actualizada"), HttpStatus.OK);
             
    }
}