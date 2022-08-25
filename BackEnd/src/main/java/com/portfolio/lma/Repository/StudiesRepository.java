
package com.portfolio.lma.Repository;

import com.portfolio.lma.Entity.Studies;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudiesRepository extends JpaRepository<Studies, Integer>{
    public Optional<Studies> findByDegreeS(String degreeS);
    public boolean existsByDegreeS(String degreeS);
}