package com.portfolio.lma.Service;


import com.portfolio.lma.Entity.WorkExperience;
import com.portfolio.lma.Repository.WExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WExperienceService {
     @Autowired
     WExperienceRepository wExperienceRepository;
     
     public List<WorkExperience> list(){
         return wExperienceRepository.findAll();
     }
     
     public Optional<WorkExperience> getOne(int id){
         return wExperienceRepository.findById(id);
     }
     
     public Optional<WorkExperience> getByNameExp(String nameExp){
         return wExperienceRepository.findByNameExp(nameExp);
     }
     
     @PreAuthorize("hasRole('ADMIN')")
     public void save(WorkExperience exp){
         wExperienceRepository.save(exp);
     }
     
     @PreAuthorize("hasRole('ADMIN')")
     public void delete(int id){
         wExperienceRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return wExperienceRepository.existsById(id);
     }
     
     public boolean existsByNameExp(String nameExp){
         return wExperienceRepository.existsByNameExp(nameExp);
     }
}