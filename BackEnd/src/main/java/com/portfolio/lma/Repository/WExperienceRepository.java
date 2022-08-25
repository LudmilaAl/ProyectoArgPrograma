package com.portfolio.lma.Repository;


import com.portfolio.lma.Entity.WorkExperience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WExperienceRepository extends JpaRepository<WorkExperience, Integer>{
    public Optional<WorkExperience> findByNameExp(String nameExp);
    public boolean existsByNameExp(String nameExp);
}