package br.com.autoservices.autocore.domain.service;

import br.com.autoservices.autocore.domain.aggregate.NewUserAggregate;
import br.com.autoservices.autocore.domain.aggregate.UserLoginAggregate;
import br.com.autoservices.autocore.domain.entities.NewUser;
import br.com.autoservices.autocore.domain.entities.UserLogin;
import br.com.autoservices.autocore.domain.repository.LoginRepository;
import br.com.autoservices.autocore.domain.repository.NewUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoserviceLoginService {

    @Autowired
    LoginRepository loginRepository;
    @Autowired
    NewUserRepository newUserRepository;

    public Boolean login (UserLoginAggregate userLoginAggregate) {
        if(userLoginAggregate == null){
            return false;
        }

        final UserLogin sameUserExist = loginRepository.findByEmailAndPasswordEquals(userLoginAggregate.getEmail(), userLoginAggregate.getPassword());
        if(sameUserExist != null){
            return true;
        }
        return false;
    }

    public Boolean createUser (NewUserAggregate newUserAggregate){
        if(newUserAggregate == null){
            return false;
        }

        NewUser verifyUserExist = newUserRepository.findByEmail(newUserAggregate.getEmail());
        if(verifyUserExist == null){
            NewUser saveUser = new NewUser();
            saveUser.setEmail(newUserAggregate.getEmail());
            saveUser.setNomeEmpresa(newUserAggregate.getNomeEmpresa());
            saveUser.setPassword(newUserAggregate.getPassword());
            newUserRepository.save(saveUser);
            return true;
        }
        return false;

    }
}
