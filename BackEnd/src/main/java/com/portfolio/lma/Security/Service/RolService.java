
package com.portfolio.lma.Security.Service;

import com.portfolio.lma.Security.Entity.Rol;
import com.portfolio.lma.Security.Enums.RolName;
import com.portfolio.lma.Security.Repository.iRolRespository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRespository irolRepository;
    
    public Optional <Rol> getByRolName(RolName rolName){
        return irolRepository.findByRolName(rolName);
    }
    
    public void save (Rol rol){
        irolRepository.save(rol);
    }
}
