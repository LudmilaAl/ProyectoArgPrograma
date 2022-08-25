
package com.portfolio.lma.Service;

import com.portfolio.lma.Entity.Studies;
import com.portfolio.lma.Repository.StudiesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudiesService {
    
    @Autowired
    StudiesRepository studiesRepository;
    
         public List<Studies> list(){
         return studiesRepository.findAll();
     }
     
     public Optional<Studies> getOne(int id){
         return studiesRepository.findById(id);
     }
     
     public Optional<Studies> getByDegreeS(String degreeS){
         return studiesRepository.findByDegreeS(degreeS);
     }
     
     @PreAuthorize("hasRole('ADMIN')")
     public void save(Studies studies){
         studiesRepository.save(studies);
     }
     
     @PreAuthorize("hasRole('ADMIN')")
     public void delete(int id){
         studiesRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return studiesRepository.existsById(id);
     }
     
     public boolean existsByDegreeS(String degreeS){
         return studiesRepository.existsByDegreeS(degreeS);
     }
}
