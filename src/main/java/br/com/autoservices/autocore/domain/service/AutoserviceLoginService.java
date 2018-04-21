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
            System.out.printf(userLoginAggregate.getEmail() + userLoginAggregate.getPassword());
            System.out.println("ENTROU NO PRIMEIRO IF: FALSE");
            return false;
        }

        final UserLogin sameUserExist = loginRepository.findByEmailAndPasswordEquals(userLoginAggregate.getEmail(), userLoginAggregate.getPassword());
        if(sameUserExist != null){
            System.out.println("ENTROU NO SEGUNDO IF: TRUE");
            return true;
        }
        System.out.println(sameUserExist);
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
