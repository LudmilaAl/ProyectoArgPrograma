
package com.portfolio.lma.Repository;

import com.portfolio.lma.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepositort extends JpaRepository<Person,Long>{
    
}
