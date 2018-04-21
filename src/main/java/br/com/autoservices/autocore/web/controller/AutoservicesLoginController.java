package br.com.autoservices.autocore.web.controller;

import br.com.autoservices.autocore.domain.aggregate.NewUserAggregate;
import br.com.autoservices.autocore.domain.aggregate.UserLoginAggregate;
import br.com.autoservices.autocore.domain.service.AutoserviceLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoservicesLoginController {

    @Autowired
    AutoserviceLoginService autoserviceLoginService;

    @RequestMapping(method = RequestMethod.POST, value = "/core-login/autoService/cadastro")
    Boolean cadastroAutoService(@RequestBody NewUserAggregate autoervicesNewUser){
        return autoserviceLoginService.createUser(autoervicesNewUser);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/core-login/autoService")
    Boolean loginAutoService(@RequestBody UserLoginAggregate userLoginAggregate) {
        return autoserviceLoginService.login(userLoginAggregate);
    }
}
