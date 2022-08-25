
package com.portfolio.lma.Security.Repository;

import com.portfolio.lma.Security.Entity.Rol;
import com.portfolio.lma.Security.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRespository extends JpaRepository<Rol,Integer>{
    Optional<Rol> findByRolName(RolName rolName);
}
