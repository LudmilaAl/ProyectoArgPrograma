
package com.portfolio.lma.Security.Service;

import com.portfolio.lma.Security.Entity.Usuario;
import com.portfolio.lma.Security.Repository.iUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    iUserRepository iuserRepository;
    
    public Optional <Usuario> getByUsername(String username){
        return iuserRepository.findByUsername(username);
    }
    
    public boolean existsByUsername(String username){
        return iuserRepository.existsByUsername(username);
    }
    
    public boolean existsByEmail(String email){
        return iuserRepository.existsByEmail(email);
    }
    
    public void save (Usuario user){
        iuserRepository.save(user);
    }
    
}
